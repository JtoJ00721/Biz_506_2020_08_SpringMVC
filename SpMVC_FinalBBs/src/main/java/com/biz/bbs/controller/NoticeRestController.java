package com.biz.bbs.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
	
	@RequestMapping(value = "/put")
	public int put() {

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

		return noticeService.insert(nVO);
	}
	
	@RequestMapping(value = "/delete/{id}")
	public int delete(@PathVariable("id") Long id) {
		
		return noticeService.delete(id);
	}
	
	@RequestMapping(value = "/update/{id}")
	public int update(@PathVariable("id") Long id) {
		
		LocalDateTime DateTime = LocalDateTime.now();
		String date = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(DateTime);
		String time = DateTimeFormatter.ofPattern("HH:mm:ss").format(DateTime);

		String date_time = date + " " + time;
		String writer = "빙빙이";
		String subject = "이모양이면";
		String text = "업데이트 성공이지롱";
		
		NoticeVO nVO = NoticeVO.builder()
				.id(id)
				.date_time(date_time)
				.writer(writer)
				.subject(subject)
				.text(text)
				.build();

		return noticeService.update(nVO);
	}
	
}
