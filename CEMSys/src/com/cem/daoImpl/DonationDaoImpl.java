package com.cem.daoImpl;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cem.dao.DonationDao;
import com.cem.queryVO.DonationQueryVo;

@Repository
public class DonationDaoImpl implements DonationDao {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
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
