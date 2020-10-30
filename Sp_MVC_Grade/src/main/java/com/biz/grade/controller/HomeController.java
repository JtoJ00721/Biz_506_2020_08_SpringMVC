package com.biz.grade.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.grade.model.GradeVO;
import com.biz.grade.service.GradeService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {

	@Autowired
	private GradeService gradeService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model, GradeVO gradeVO) {

		List<GradeVO> gradeList = gradeService.selectAll();
		model.addAttribute("LIST", gradeList);

		return "home";
	}

	@RequestMapping(value = "/input", method = RequestMethod.GET)
	public String input() {
		return "write";
	}

	@RequestMapping(value = "/input", method = RequestMethod.POST)
	public String input(@ModelAttribute GradeVO gradeVO, Model model) {

		gradeVO.setSum(gradeVO.getGuk() + gradeVO.getYoung() + gradeVO.getSu());
		gradeVO.setAvg(gradeVO.getSum() / 3);

		int ret = gradeService.insert(gradeVO);

		if (ret > 0) {
			log.debug("\n\nINSERT 성공\n\n");
		} else {
			log.debug("\n\nINSERT 실패\n\n");
		}

		return "redirect:/";
	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update(Long seq, Model model) {

		GradeVO gradeVO = gradeService.findById(seq);
		model.addAttribute("INFO", gradeVO);
		return "/write";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(GradeVO gradeVO) {
		
		gradeVO.setSum(gradeVO.getGuk() + gradeVO.getYoung() + gradeVO.getSu());
		gradeVO.setAvg(gradeVO.getSum() / 3);

		int ret = gradeService.update(gradeVO);
		if (ret > 0) {
			log.debug("\n\n업데이트 성공\n\n");
		} else {
			log.debug("\n\n업데이트 실패 ><\n\n");
		}
		return "redirect:/";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(Long seq) {
		int ret = gradeService.delete(seq);
		if (ret > 0) {
			log.debug("\n\n삭제 성공\n\n");
		} else {
			log.debug("\n\n삭제 실패\n\n");
		}
		return "redirect:/";
	}

}
