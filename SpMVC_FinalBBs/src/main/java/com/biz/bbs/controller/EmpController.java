package com.biz.bbs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.biz.bbs.model.EmployeesVO;
import com.biz.bbs.service.EmployeesService;

@RestController
public class EmpController {

	@Autowired
	@Qualifier("empServiceV1")
	private EmployeesService empService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<EmployeesVO> list() {

		List<EmployeesVO> empList = empService.selectAll();

		return empList;
	}

	@RequestMapping(value = "/select/{id}", method = RequestMethod.GET)
	public EmployeesVO selectOne(@PathVariable("id") Long id) {
		
		EmployeesVO empVO = empService.findById(id);

		return empVO;
	}
	

}
