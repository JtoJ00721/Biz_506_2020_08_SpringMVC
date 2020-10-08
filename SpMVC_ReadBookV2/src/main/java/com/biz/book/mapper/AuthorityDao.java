package com.biz.book.mapper;

import java.util.List;

import com.biz.book.model.AuthorityVO;

public interface AuthorityDao extends GenericaDao<AuthorityVO, Long>{
	
	public int insertAll(List<AuthorityVO> authList);
	public List<AuthorityVO> findByUserName(String username);
	
}
