package com.biz.bbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.biz.bbs.mapper.EmployeesDao;
import com.biz.bbs.model.EmployeesVO;

@Service
@Qualifier("empServiceV1")
public class EmployeesServiceImplV1 implements EmployeesService {

	@Autowired
	private EmployeesDao empDao;

	@Override
	public List<EmployeesVO> selectAll() {
		List<EmployeesVO> empAllList = empDao.seletctAll();
		return empAllList;
	}

	@Override
	public EmployeesVO findById(Long id) {

		EmployeesVO empVO = empDao.findById(id);

		return empVO;
	}

	@Override
	public int insert(EmployeesVO empVO) {

		int ret = empDao.insert(empVO);

		return ret;
	}

	@Override
	public int update(EmployeesVO empVO) {

		int ret = empDao.update(empVO);

		return ret;
	}

	@Override
	public int delete(Long id) {

		int ret = empDao.delete(id);

		return ret;
	}

}
