package com.biz.bbs.mapper;

import java.util.List;

import com.biz.bbs.model.EmployeesVO;

public interface GenericDao<VO, PK> {

	public List<VO> seletctAll();

	public VO findById(PK id);

	public int insert(VO vo);

	public int update(VO vo);

	public int delete(PK id);

}
