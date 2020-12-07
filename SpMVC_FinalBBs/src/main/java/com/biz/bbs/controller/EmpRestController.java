package com.biz.bbs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

	@RequestMapping(value = "/put", method = RequestMethod.GET)
	public int insertYeem() {

		EmployeesVO empVO = new EmployeesVO();

		empVO.setFirst_name("농");
		empVO.setLast_name("농이");
		empVO.setAddress("구대륙");
		empVO.setTel("010-222-2222");
		empVO.setEmail("nong@nong");

		return empService.insert(empVO);

	}
	
	@RequestMapping(value = "/update/{id}")
	public int insertYeem(@PathVariable("id") Long id) {

		EmployeesVO empVO = new EmployeesVO();

		empVO.setId(id);
		empVO.setFirst_name("빙");
		empVO.setLast_name("빙이");
		empVO.setAddress("구대륙");
		empVO.setTel("010-222-6974");
		empVO.setEmail("bing@bing");

		return empService.update(empVO);

	}

}
