package com.cem.daoImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cem.dao.RecruitmentDao;
import com.cem.pojo.Recruitment;
import com.cem.queryVO.RecruitmentQueryVo;

@Repository("recruitmentDao")
public class RecruitmentDaoImpl implements RecruitmentDao {
	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void insertRecruitment(Recruitment recruitment) throws Exception {
		Session session = getSession();
		session.save(recruitment);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> findAll(RecruitmentQueryVo queryVo) throws Exception {
		Session session = getSession();
		/*
		 * 以下是有关查询限制的条件
		 */
		int pageIndex = queryVo.getPageIndex();
		int pageSize = queryVo.getPageSize();
		String publishPerson = queryVo.getPublishPerson();
		String publishForedate = queryVo.getPubForedate();
		String publishAfterdate = queryVo.getPubAfterdate();
		String viewAll = queryVo.getViewAll();
		String pubCompany = queryVo.getPubCompany();
		/*
		 * 以上是有关查询限制的条件
		 */
		StringBuilder hql = new StringBuilder("FROM Recruitment re WHERE re.isDeleted='0' ");
		/*
		 * 判断查询条件组装hql查询语句
		 */
		if (viewAll == null || viewAll.length() == 0) {// 说明查看全部记录
			if (publishPerson != null && publishPerson.length() != 0) {
				hql.append(" AND re.truename like '%" + publishPerson + "%'");
			}
			if (publishForedate != null && publishForedate.length() != 0) {
				/*
				 * 这里要分情况，如果只填写了开始日期，但是没有填写终止日期， 那么查询晚于起始日期的符合条件的所有记录
				 */
				if (publishAfterdate != null && publishAfterdate.length() != 0) {
					hql.append(" AND re.publishDate BETWEEN '" + publishForedate + "' AND '" + publishAfterdate + "'");
				} else {
					hql.append(" AND re.publishDate >= '" + publishForedate + "'");
				}
			}
			if (pubCompany != null && pubCompany.length() != 0) {
				hql.append(" AND re.companyName like '%" + pubCompany + "%'");
			}
		}
		/*
		 * 查询总记录数，暂时没想到一举两得的办法,只能执行两次查询
		 */
		int recordCount = Integer.parseInt(String.valueOf(session.createQuery("SELECT COUNT(*) " + hql.toString()).uniqueResult()));
		List<Recruitment> recruitmentList = session.createQuery(hql.toString() + " ORDER BY re.publishDate desc")
				.setFirstResult((pageIndex - 1) * pageSize).setMaxResults(pageSize).list();
		Map<String, Object> resultMap = new HashMap<String, Object>(2);
		resultMap.put("resultList", recruitmentList);
		resultMap.put("recordCount", recordCount);
		return resultMap;
	}
}
