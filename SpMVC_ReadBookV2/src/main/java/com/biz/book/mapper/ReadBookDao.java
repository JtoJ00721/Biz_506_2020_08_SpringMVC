package com.biz.book.mapper;

import java.util.List;

import com.biz.book.model.ReadBookVO;

public interface ReadBookDao extends GenericaDao<ReadBookVO, Long> {

	public List<ReadBookVO> findByBSeq(Long r_book_seq);

}
