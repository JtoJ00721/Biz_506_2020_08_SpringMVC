package com.biz.grade.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.grade.mapper.GradeDao;
import com.biz.grade.model.GradeVO;

@Service
public class GradeService {

	@Autowired
	private GradeDao gradeDao;

	public List<GradeVO> selectAll() {
		List<GradeVO> gradeList = gradeDao.selectAll();
		return gradeList;
	}

	public GradeVO findById(Long seq) {
		GradeVO gradeVO = gradeDao.findById(seq);
		return gradeVO;
	}

	public int insert(GradeVO gradeVO) {
		int ret = gradeDao.insert(gradeVO);
		return ret;
	}

	public int update(GradeVO gradeVO) {
		return gradeDao.update(gradeVO);
	}

	public int delete(Long seq) {
		int ret = gradeDao.delete(seq);
		return ret;
	}

}
