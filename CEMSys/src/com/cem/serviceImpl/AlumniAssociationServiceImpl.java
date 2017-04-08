package com.cem.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cem.dao.AlumniAssociationDao;
import com.cem.pojo.AlumniAssociation;
import com.cem.service.AlumniAssociationService;

@Service
public class AlumniAssociationServiceImpl implements AlumniAssociationService {

	@Autowired
	AlumniAssociationDao alumniAssociationDao = null;

	@Override
	public AlumniAssociation findById(Integer id) throws Exception {
		return alumniAssociationDao.findById(id);
	}

	@Override
	public void merge(AlumniAssociation alumniAssociation) throws Exception {
		alumniAssociationDao.merge(alumniAssociation);
	}

	@Override
	public void insert(AlumniAssociation alumniAssociation) throws Exception {
		alumniAssociationDao.insert(alumniAssociation);
	}

	@Override
	public List<AlumniAssociation> findAll() throws Exception {
		return alumniAssociationDao.findAll();
	}
}
