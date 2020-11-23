package com.biz.book.service;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.data.domain.Page;

import com.biz.book.domain.BookVO;

public interface BookService {
	
	public List<BookVO> selectAll();
	
	public Page<BookVO> pageSelect(Pageable pageable);
	
	public BookVO findById(Long id);
	public int insert(BookVO bookVO);
	public int update(BookVO bookVO);
	public int delete(Long id);

}
