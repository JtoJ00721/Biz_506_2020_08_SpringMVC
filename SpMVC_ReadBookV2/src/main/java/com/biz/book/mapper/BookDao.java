package com.biz.book.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import com.biz.book.model.BookVO;

/*
 * GenericDao를 extends 하면 
 * 기본 CRUD 메서드를 
 * 별도로 정의하지 않아도 된다.
 */
public interface BookDao extends GenericaDao<BookVO, Long>{
	
	@Select("SELECT * FROM tbl_books WHERE seq = #{id}")
	public BookVO findById(long id);
	
	@Delete("DELETE FROM tbl_books WHERE seq = #{id}")
	public int delete(Long id);
	
}