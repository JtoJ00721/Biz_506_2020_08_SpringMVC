package com.biz.book.service;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.data.domain.Page;

import com.biz.book.domain.BookVO;

public class BookServiceImplV1 implements BookService {

	@Override
	public List<BookVO> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<BookVO> pageSelect(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BookVO findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(BookVO bookVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(BookVO bookVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
