package com.biz.bbs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biz.bbs.model.EmployeesVO;
import com.biz.bbs.service.EmployeesService;

@RestController
@RequestMapping(value = "/emp")
public class EmpRestController {

	@Autowired
	@Qualifier("empServiceV1")
	private EmployeesService empService;

	@RequestMapping(value = "/list")
	public List<EmployeesVO> list() {

		return empService.selectAll();
	}

	@RequestMapping(value = "/select/{id}")
	public EmployeesVO selectOne(@PathVariable("id") Long id) {
		
		return empService.findById(id);
	}
	

}
