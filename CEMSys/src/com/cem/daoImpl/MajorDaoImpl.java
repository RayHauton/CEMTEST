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

import com.cem.customPojo.MajorCustom;
import com.cem.dao.MajorDao;
import com.cem.pojo.Major;
import com.cem.util.GenerateHqlSectionUtil;
@Repository
public class MajorDaoImpl implements MajorDao {
	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	
	
	
	@Override
	public String findMaxId() throws Exception {
		Session session = getSession();
		return (String) session.createQuery("SELECT MAX(majorId) FROM Major WHERE isDeleted='0'").uniqueResult();
	}




	@Override
	public List<MajorCustom> findAllWithDegreeInfo() throws Exception {
		ArrayList<MajorCustom> majorCustomList = new ArrayList<>();
		Session session = getSession();
		session.doWork(new Work() {
			
			@Override
			public void execute(Connection con) throws SQLException {
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				MajorCustom pojo = null;
				try{
					String sql = "select d.degreeId,d.degreeName,m.majorId,majorName from degree d,major m,schoolexperience se "
							+ "where m.majorId=se.majorId and d.degreeId=se.degreeId and se.isDeleted='0' and d.isDeleted='0' and m.isDeleted='0' order by m.majorId asc, d.degreeId asc";
					pstmt = con.prepareStatement(sql);
					rs = pstmt.executeQuery();
					while(rs.next()){
						pojo = new MajorCustom();
						pojo.setDegreeId(rs.getString(1));
						pojo.setDegreeName(rs.getString(2));
						pojo.setMajorId(rs.getString(3));
						pojo.setMajorName(rs.getString(4));
						majorCustomList.add(pojo);
					}
				}catch(SQLException ex){
					ex.printStackTrace();
				}finally{
					if(pstmt!=null){
						pstmt.close();
					}
					if(rs!=null){
						rs.close();
					}
				}
			}
		});
		return majorCustomList;
	}




	@Override
	public void insert(Major major) throws Exception {
		getSession().save(major);
	}



	@SuppressWarnings("unchecked")
	@Override
	public List<Major> findByMajorIdList(List<String> majorIdList) throws Exception {
		Session session = getSession();
		if(majorIdList.size()!=0){//如果有记录的情况
			String hql = "FROM Major WHERE isDeleted='0' AND majorId IN "+new GenerateHqlSectionUtil().generateHql_IN(majorIdList);
			return session.createQuery(hql).list();
		}else{//没有对应记录
			return null;
		}
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Major> findAll() throws Exception {
		Session session = getSession();
		return session.createQuery("FROM Major WHERE isDeleted='0'").list();
	}

	@Override
	public Major findByMajorId(String majorId) throws Exception {
		Session session = getSession();
		return (Major) session.createQuery("FROM Major WHERE majorId=? AND isDeleted='0'").setParameter(0, majorId)
				.uniqueResult();
	}

}
