package com.biz.book.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.book.mapper.BookDao;
import com.biz.book.model.BookVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
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
		model.addAttribute("BOOKS", bookList);
		model.addAttribute("BODY", "BOOK-LIST");

		return "home";
	}

	@RequestMapping(value = "/input", method = RequestMethod.GET)
	public String input(Model model) {
		
		LocalDate localDate = LocalDate.now();
		String todayString = DateTimeFormatter.ofPattern("YYYY-MM-dd").format(localDate);
		
		BookVO bookVO = BookVO.builder().buydate(todayString).build();
				

		model.addAttribute("BODY", "BOOK-WRITE");
		model.addAttribute("bookVO", bookVO);

		return "home";

		// Controller의 Mapping method의 return type이 String일때
		// null값을 return 하면
		// method를 호출할때 사용했던 mapping URL.jsp 형식의 return문이
		// 자동으로 생성된다.
		// return null;
	}
	
	/*
	 * spring form taglib을 사용하여 입력 write form을 만들었을 경우에는
	 * VOP클래스, 객체를 매개변수로 사용할때
	 * @ModelAttribute("VO")를 필수로 사용하자
	 */
	@RequestMapping(value = "/input",method = RequestMethod.POST)
	public String input (@ModelAttribute("bookVO") BookVO bookVO) {
		
		log.debug(bookVO.toString());
		
		int ret = bookDao.insert(bookVO);
		if(ret < 1) {
			// insert가 실패했으므로 그에 대한 메시지를 보여주는 페이지로 점프한다
		}
		
		return "redirect:/books";
	}

}
