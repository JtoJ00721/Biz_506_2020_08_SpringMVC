package com.biz.bbs.service;

import java.util.List;

import com.biz.bbs.model.EmployeesVO;

public interface EmployeesService {

	public List<EmployeesVO> selectAll();

	public EmployeesVO findById(Long id);

	public int insert(EmployeesVO empVO);

	public int update(EmployeesVO empVO);

	public int delete(Long id);

}
