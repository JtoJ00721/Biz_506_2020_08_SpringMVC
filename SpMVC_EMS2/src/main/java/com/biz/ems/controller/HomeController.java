package com.biz.ems.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.ems.model.EmsVO;
import com.biz.ems.service.EmsService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {

	@Autowired
	@Qualifier("emsServiceV1")
	private EmsService emsService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		List<EmsVO> emsList = emsService.selectAll();
		model.addAttribute("EMS_LIST", emsList);
		
		return "home";
	}

	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String write() {
		return "ems-write";
	}

	@RequestMapping(value = "/write", method = RequestMethod.POST)
//	public String write(String from_email, String to_email, String s_subject, Model model) {
	public String write(@ModelAttribute EmsVO emsVO, Model model) {

		log.debug("\n\n\n EMSVO {} \n\n\n", emsVO.toString());
		
		int ret = emsService.insert(emsVO);
		if(ret > 0) {
			log.debug("\n\n\nINSERT 수행한 후 결과 {}개 성공\n\n\n", ret);
		} else {
			log.debug("\n\n\nINSERT 실패 ><\n\n\n");
		}
		
//		model.addAttribute("from_email", emsVO.getFrom_email());
//		model.addAttribute("to_email", emsVO.getTo_email());
//		model.addAttribute("s_subject", emsVO.getS_subject());

		model.addAttribute("EMS", emsVO);

		return "redirect:/";
	}

	/*
	 * 목록보기에서 제목을 클릭하면
	 * id값을 변수로 넘기면서 update, GET로 호출이 된다.
	 * id값으로 findById() 조회를 해서 EmsVO를 DB로부터 Select하고
	 * 그 결과를 model에 담아서 다시 ems-write.jsp로 보내기 
	 */
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update(String id, Model model) {
		Long long_id = Long.valueOf(id);
		EmsVO emsVO = emsService.findById(long_id);
		model.addAttribute("EMS", emsVO);
		return "ems-write";
	}
	

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(EmsVO emsVO) {
		log.debug("UPDATE 요청 데이터 {}", emsVO.toString());
		return "ems-view";
	}

	public String delete(String id) {
		return "redirect:/";
	}

}
