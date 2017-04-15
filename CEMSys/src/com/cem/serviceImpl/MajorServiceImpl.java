package com.cem.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cem.customPojo.MajorCustom;
import com.cem.dao.MajorDao;
import com.cem.pojo.Major;
import com.cem.service.MajorService;

@Service
public class MajorServiceImpl implements MajorService {
	@Autowired
	private MajorDao majorDao;

	
	
	@Override
	public void merge(Major major) throws Exception {
		majorDao.merge(major);
	}

	@Override
	public String findMaxId() throws Exception {
		return majorDao.findMaxId();
	}

	@Override
	public List<MajorCustom> findAllWithDegreeInfo() throws Exception {
		return majorDao.findAllWithDegreeInfo();
	}

	@Override
	public void insert(Major major) throws Exception {
		majorDao.insert(major);
	}

	@Override
	public List<Major> findAll() throws Exception {
		return majorDao.findAll();
	}

	@Override
	public Major findByMajorId(String majorId) throws Exception {
		return majorDao.findByMajorId(majorId);
	}

	@Override
	public List<Major> findByMajorIdList(List<String> majorIdList) throws Exception {
		return majorDao.findByMajorIdList(majorIdList);
	}

}
