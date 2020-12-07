package com.biz.bbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.biz.bbs.mapper.NoticeDao;
import com.biz.bbs.model.NoticeVO;

@Service
@Qualifier("noticeServiceV1")
public class NoticeServiceImplV1 implements NoticeService{
	
	@Autowired
	private NoticeDao noticeDao;

	@Override
	public List<NoticeVO> selectAll() {
		
		return noticeDao.seletctAll();
	}

	@Override
	public NoticeVO findById(Long id) {
		
		return noticeDao.findById(id);
	}

	@Override
	public int insert(NoticeVO vo) {
		
		int ret = noticeDao.insert(vo);
		
		return ret;
	}

	@Override
	public int update(NoticeVO vo) {
		
		int ret = noticeDao.update(vo);
		
		return ret;
	}

	@Override
	public int delete(Long id) {
		
		int ret = noticeDao.delete(id);
		
		return ret;
	}

}
