package com.biz.data.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.biz.data.model.GoPetVO;
import com.biz.data.service.PetServiceImplV1;

@Controller
@RequestMapping(value = "/pet")
public class PetController {

	@Autowired
	private PetServiceImplV1 petService;
	
	@RequestMapping(value = "/getHos")
	public List<GoPetVO> getHospital() {
		
		return petService.getHost();
	}
}
