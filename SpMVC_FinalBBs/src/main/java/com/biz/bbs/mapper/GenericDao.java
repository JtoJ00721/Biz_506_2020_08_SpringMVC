package com.biz.bbs.mapper;

import java.util.List;

import com.biz.bbs.model.EmployeesVO;

public interface GenericDao<VO, PK> {

	public List<VO> seletctAll();

	public VO findById(Long id);

	public int insert(EmployeesVO empVO);

	public int update(EmployeesVO empVO);

	public int delete(Long id);

}
