package com.cem.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.jdbc.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cem.customPojo.UserCustom;
import com.cem.dao.MajorDao;
import com.cem.dao.SchoolExperienceDao;
import com.cem.globalException.GlobalCustomException;
import com.cem.pojo.Major;
import com.cem.pojo.Schoolexperience;

@Repository
public class SchoolExperienceDaoImpl implements SchoolExperienceDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private MajorDao majorDao;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Schoolexperience> findSEByMajorId(String majorId) throws Exception {
		return getSession().createQuery("FROM Schoolexperience se WHERE se.majorId=? AND se.isDeleted='0'").setParameter(0, majorId).list();
	}



	@Override
	public void insert(Schoolexperience se) throws Exception {
		getSession().save(se);
	}



	@Override
	public void update(Schoolexperience se) throws Exception {
		getSession().update(se);
	}



	/**
	 * 根据专业Id找到学位Id
	 */
	@Override
	public List<String> findDegreeIdByMajorId(String majorId) throws Exception {
		List<String> degreeIds = new ArrayList<String>();
		getSession().doWork(new Work() {
			@Override
			public void execute(Connection con) throws SQLException {
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				try{
					String sql = "select degreeId from schoolexperience se where se.majorId=? and se.isDeleted='0'";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, majorId);
					rs = pstmt.executeQuery();
					while(rs.next()){
						degreeIds.add(rs.getString(1));
					}
				}catch(SQLException ex){
					ex.printStackTrace();
				}finally {
					if(pstmt!=null){
						pstmt.close();
					}
					if(rs!=null){
						rs.close();
					}
					if(con!=null){
						con.close();
					}
				}
			}
		});
		return degreeIds;
	}

	@Override
	public String findMaxId() throws Exception {
		return (String) getSession()
				.createQuery("SELECT MAX(schooleExperienceId) FROM Schoolexperience WHERE isDeleted='0'")
				.uniqueResult();
	}

	@Override
	public void insertSEBatch(List<Schoolexperience> seList) throws Exception {
		Session session = getSession();
		for (Schoolexperience item : seList) {
			session.save(item);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> Schoolexperience findSchoolExperienceByMajorIdAndDegreeId(T... condition) throws Exception {
		Session session = getSession();
		String degreeId = null;
		String majorId = null;
		T t = condition[0];
		if (condition.length == 1 && t instanceof UserCustom) {
			// 说明传入的是UserCustom参数；
			UserCustom userCustom = (UserCustom) condition[0];
			degreeId = userCustom.getDegreeId();
			majorId = userCustom.getMajorId();
		} else if (condition.length == 2 && t instanceof String) {
			// 传入的是degreeId，majorId
			degreeId = (String) condition[0];
			majorId = (String) condition[1];
		} else {
			// 参数传入错误
			throw new GlobalCustomException("违反参数传入规则，只传入UserCustom实例，或者传入degreeId，majorId，二者顺序不可颠倒！");
		}
		String hql = "FROM Schoolexperience se WHERE se.degreeId=? AND se.majorId=? AND se.isDeleted='0'";
		return (Schoolexperience) session.createQuery(hql).setParameter(0, degreeId).setParameter(1, majorId)
				.uniqueResult();
	}

	@Override
	public Schoolexperience findBySchoolExpericenceId(String SEId) throws Exception {
		Session session = getSession();
		return (Schoolexperience) session.createQuery("FROM Schoolexperience se WHERE se.isDeleted='0' AND se.schooleExperienceId=?")
				.setParameter(0, SEId).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Major> findMajorsByDegreeId(String degreeId) throws Exception {
		Session session = getSession();
		List<String> majorIds = session
				.createQuery("SELECT se.majorId FROM Schoolexperience se WHERE se.degreeId=? AND se.isDeleted='0'")
				.setParameter(0, degreeId).list();
		return majorDao.findByMajorIdList(majorIds);
	}

}
