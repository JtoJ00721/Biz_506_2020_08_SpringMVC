package com.biz.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.biz.book.model.BookVO;
import com.biz.book.service.NaverService;

/*
 * view를 return response하지않고
 *  객체, 문자열 등을 직접 JSON형태로
 * response하는 Controller
 */
@RestController
@RequestMapping("/book/api")
public class BookApiController {

	@Autowired
	@Qualifier(value = "naverServiceV2")
	private NaverService<BookVO> nService;

	@RequestMapping(value = "/naver", method = RequestMethod.POST)
	public BookVO naverSearch(String search_text) {

		String queryURL = nService.queryURL("BOOK", search_text);
		BookVO bookVO = nService.getNaverList(queryURL).get(0);
		return bookVO;
	}

}
