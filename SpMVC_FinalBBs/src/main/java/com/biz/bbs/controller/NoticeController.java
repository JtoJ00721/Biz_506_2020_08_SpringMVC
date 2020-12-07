package com.biz.bbs.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.biz.bbs.model.NoticeVO;
import com.biz.bbs.service.NoticeService;

@Controller
@RequestMapping(value = "/notice")
public class NoticeController {

	@Autowired
	@Qualifier("noticeServiceV1")
	private NoticeService noticeService;

	@RequestMapping(value = "/put")
	public String put() {

		LocalDateTime DateTime = LocalDateTime.now();
		String date = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(DateTime);
		String time = DateTimeFormatter.ofPattern("HH:mm:ss").format(DateTime);

		String date_time = date + " " + time;
		String writer = "농농이";
		String subject = "제목이지롱";
		String text = "내용용이";

		NoticeVO nVO = NoticeVO.builder()
				.date_time(date_time)
				.writer(writer)
				.subject(subject)
				.text(text)
				.build();

		noticeService.insert(nVO);

		return "redirect:/";
	}
	
	@RequestMapping(value = "/update/{id}")
	public String update(@PathVariable("id") Long id) {
		return null;
	}
}
