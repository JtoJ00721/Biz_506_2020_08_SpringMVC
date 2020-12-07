package com.biz.bbs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biz.bbs.model.NoticeVO;
import com.biz.bbs.service.NoticeService;

@RestController
@RequestMapping(value = "notice")
public class NoticeRestController {
	
	@Autowired
	@Qualifier("noticeServiceV1")
	private NoticeService noticeService;
	
	@RequestMapping(value = "/list")
	public List<NoticeVO> list(){
		
		return noticeService.selectAll();
		
	}
	
	@RequestMapping(value = "/select/{id}")
	public NoticeVO selectOne(@PathVariable("id") Long id) {
		
		return noticeService.findById(id);
		
	}
	
}
