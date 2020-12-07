package com.biz.bbs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.bbs.model.EmployeesVO;
import com.biz.bbs.service.EmployeesService;

@Controller
@RequestMapping(value = "/emp")
public class EmpController {

	@Qualifier("empServiceV1")
	@Autowired
	private EmployeesService empService;

	@RequestMapping(value = "/put", method = RequestMethod.GET)
	public String insertYeem() {

		EmployeesVO empVO = new EmployeesVO();

		empVO.setFirst_name("농");
		empVO.setLast_name("농이");
		empVO.setAddress("구대륙");
		empVO.setTel("010-222-2222");
		empVO.setEmail("nong@nong");

		empService.insert(empVO);

		return "redirect:/";

	}

}
