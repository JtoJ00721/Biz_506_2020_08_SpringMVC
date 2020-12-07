package com.biz.bbs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import com.biz.bbs.model.NoticeVO;

public interface NoticeDao extends GenericDao<NoticeVO, Long> {

	@Override
	@Select("SELECT * FROM tbl_notice")
	public List<NoticeVO> seletctAll();

	@Override
	@Select("SELECT * FROM tbl_notice WHERE id = #{id}")
	public NoticeVO findById(Long id);

	@Override
	@Delete("DELETE FROM tbl_notice WHERE id = #{id}")
	public int delete(Long id);

}
