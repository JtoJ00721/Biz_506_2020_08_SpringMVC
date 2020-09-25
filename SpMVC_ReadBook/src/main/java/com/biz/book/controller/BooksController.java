package com.biz.book.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.biz.book.mapper.BookDao;
import com.biz.book.model.BookVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value = "/books")
public class BooksController {

	@Autowired
	private BookDao bookDao;

	@Transactional
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
	 * spring form taglib을 사용하여 입력 write form을 만들었을 경우에는 VOP클래스, 객체를 매개변수로 사용할때
	 * 
	 * @ModelAttribute("VO")를 필수로 사용하자
	 */
	@RequestMapping(value = "/input", method = RequestMethod.POST)
	public String input(@ModelAttribute("bookVO") BookVO bookVO) {

		log.debug(bookVO.toString());

		int ret = bookDao.insert(bookVO);
		if (ret < 1) {
			// insert가 실패했으므로 그에 대한 메시지를 보여주는 페이지로 점프한다
		}

		return "redirect:/books";
	}

	// localhost:8080/book/books/detail/3 이라고 Request가 오면
	// 맨 끝의 숫자 3을 Mapping 주소의 {book_seq}위치에 Mapping한다
	// 매개변수에 설정된 PathVariable에 따라 String id 변수에
	// 3의 값이 할당되어 method에 전달된다.
	@RequestMapping(value = "/detail/{book_seq}", method = RequestMethod.GET, produces = "application/json;charset=utf8")
	public String detail(@PathVariable("book_seq") String id, Model model) {

		log.debug("PATH: {}", id);
		long seq = Long.valueOf(id);
		BookVO bookVO = bookDao.findById(seq);
		// log.debug(bookVO.toString());

		model.addAttribute("BOOKVO", bookVO);
		model.addAttribute("BODY","BOOK-DETAIL");
		return "home";
	}

}
