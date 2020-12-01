package com.biz.bbs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import com.biz.bbs.model.EmployeesVO;

public interface EmployeesDao extends GenericDao<EmployeesVO, Long> {

	@Override
	@Select("SELECT * FROM tbl_employees")
	public List<EmployeesVO> seletctAll();

	@Override
	@Select("SELECT * FROM tbl_employees WHERE id = #{id}")
	public EmployeesVO findById(Long id);

	@Override
	@Delete("DELETE FROM tbl_employees WHERE id = #{id}")
	public int delete(Long id);

}
