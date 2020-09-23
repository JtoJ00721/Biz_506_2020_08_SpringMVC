package com.biz.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.book.mapper.BookDao;
import com.biz.book.model.BookVO;

@Controller
@RequestMapping(value = "/books")
public class BooksController {

	@Autowired
	private BookDao bookDao;

	// localhost:8080/book/books/ value부분을 문자열 배열로 만들지 않으면 반드시 이렇게 쳐야하는데 왠지 띠꺼우므로
	// localhost:8080/book/books 이렇게 쳐도 되게 개조하자
	// @ResponseBody // 객체를 그대로 JSON 형태로 보내라
	@RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
	public String list(Model model) {

		List<BookVO> bookList = bookDao.selectAll();
		model.addAttribute("BOOKS",bookList);
		
		return "books/book-list";
	}
	
	@RequestMapping(value = "/input",method=RequestMethod.GET)
	public String input () {
		
		return "books/book-write";
		
		// Controller의 Mapping method의 return type이 String일때
		// null값을 return 하면
		// method를 호출할때 사용했던 mapping URL.jsp 형식의 return문이
		// 자동으로 생성된다.
		// return null;
		
	}

}
