package com.cem.daoImpl;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cem.customPojo.UserCustom;
import com.cem.dao.DonationDao;
import com.cem.pojo.Degree;
import com.cem.pojo.Major;
import com.cem.pojo.Schoolexperience;
import com.cem.queryVO.DonationQueryVo;
import com.cem.util.BaseDataUtil;

@Repository
public class DonationDaoImpl implements DonationDao {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public UserCustom findDonorInfo(UserCustom userCustom) throws Exception {
		UserCustom user = new UserCustom();
		/*
		 * 首先根据userId查询学历Id
		 */
		Session session = getSession();
		String schoolExperienceId = (String) session
				.createQuery("SELECT schoolExperienceId FROM User WHERE userId=? AND isDeleted='0'")
				.setParameter(0, userCustom.getUserId()).uniqueResult();
		/*
		 * 根据学历ID查找学历信息
		 */
		Schoolexperience se = (Schoolexperience) session
				.createQuery("FROM Schoolexperience se WHERE se.isDeleted='0' AND se.schooleExperienceId=?")
				.setParameter(0, schoolExperienceId).uniqueResult();
		/*
		 * 根据学历实体类查找对应的学位名称以及专业名称
		 */
		user.setMajorName(((Major) BaseDataUtil.getMajorMap().get(se.getMajorId())).getMajorName());
		user.setDegreeName(((Degree) BaseDataUtil.getDegreeMap().get(se.getDegreeId())).getDegreeName());

		/*
		 * 查找用户入学时间
		 */
		Object[] userInfo = (Object[]) session
				.createQuery("SELECT truename,entranceDate FROM User WHERE userId=? AND isDeleted='0'")
				.setParameter(0, userCustom.getUserId()).uniqueResult();
		user.setTruename((String)userInfo[0]);
		user.setEntranceDate((String)userInfo[1]);
		user.setUserId(userCustom.getUserId());
		return user;
	}

	@Override
	public Map<String, Object> findAll(DonationQueryVo queryVo) throws Exception {
		HashMap<String, Object> resultMap = new HashMap<>(2);
		/*
		 * 获得查询条件封装类中的查询信息
		 */
		String truename = queryVo.getTruename();
		String donationProject = queryVo.getDonationProject();
		String donationType = queryVo.getDonationType();
		String foredate = queryVo.getForedate();
		String afterdate = queryVo.getAfterdate();
		Integer pageIndex = queryVo.getPageIndex();
		Integer pageSize = queryVo.getPageSize();
		/*
		 * 根据查询条件封装类进行查询语句的拼接
		 */
		StringBuilder hql = new StringBuilder("FROM Donation d WHERE d.isDeleted='0' ");// 抽取查询语句公共部分
		if (truename != null && truename.length() != 0) {
			hql.append(" AND d.truename like '%" + truename + "%'");
		}
		if (donationProject != null && donationProject.length() != 0) {
			hql.append(" AND d.donationProject like '%" + donationProject + "%'");
		}
		if (donationType != null && donationType.length() != 0) {
			hql.append(" AND d.donationType='" + donationType + "'");
		}
		if (foredate != null && foredate.length() != 0) {
			if (afterdate != null && afterdate.length() != 0) {
				hql.append(" AND d.donationDate BETWEEN '" + foredate + "' AND '" + afterdate + "'");
			} else {
				hql.append(" AND d.donationDate >='" + foredate + "'");
			}
		}
		Session session = getSession();
		/*
		 * 获得记录数
		 */
		int recordCount = Integer.parseInt(
				String.valueOf((Long) session.createQuery("SELECT COUNT(*) " + hql.toString()).uniqueResult()));
		resultMap.put("recordCount", recordCount);
		/*
		 * 获得记录
		 */
		resultMap.put("resultList", session.createQuery(hql.toString()).setFirstResult((pageIndex - 1) * pageSize)
				.setMaxResults(pageSize).list());
		return resultMap;
	}

}
