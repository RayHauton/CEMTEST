package com.cem.daoImpl;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cem.dao.CollegeEventDao;
import com.cem.pojo.Collegeevent;
import com.cem.queryVO.CollegeEventQueryVo;

@Repository
public class CollegeEventDaoImpl implements CollegeEventDao {
	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	
	/*
	 * (non-Javadoc)
	 * @see com.cem.dao.CollegeEventDao#deleteById(java.lang.Integer)
	 * 根据ID删除事件记录
	 */
	@Override
	public void deleteById(Integer eventId) throws Exception {
	}



	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cem.dao.CollegeEventDao#findById(java.lang.Integer) 根据id查询事件记录
	 */
	@Override
	public Collegeevent findById(Integer eventId) throws Exception {
		Session session = getSession();
		String hql = "FROM Collegeevent clg WHERE clg.isDeleted='0' AND clg.eventId=?";
		/*
		 * 根据ID查询出的记录只有一条;
		 */
		// Collegeevent clgevnt = session.createQuery(hql).setParameter(0,
		// eventId).setFirstResult(0).setMaxResults(1).list();
		Collegeevent clgevnt = (Collegeevent) session.createQuery(hql).setParameter(0, eventId).uniqueResult();
		return clgevnt;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cem.dao.CollegeEventDao#update(com.cem.pojo.Collegeevent) 更新记录
	 */
	@Override
	public void merge(Collegeevent collegeevent) throws Exception {
		Session session = getSession();
		session.merge(collegeevent);
	}

	@Override
	public void add(Collegeevent collegeevent) throws Exception {
		Session session = getSession();
		session.save(collegeevent);
	}

	@Override
	public Map<String, Object> findAll(CollegeEventQueryVo colgEvntQueryVo) throws Exception {
		Session session = getSession();
		Map<String, Object> resultMap = new HashMap<>(2);
		StringBuilder oriHql = new StringBuilder("FROM Collegeevent cg WHERE cg.isDeleted='0'");
		/*
		 * 根据查询条件组装查询语句
		 */
		int pageIndex = colgEvntQueryVo.getPageIndex();
		int pageSize = colgEvntQueryVo.getPageSize();
		String foredate = colgEvntQueryVo.getForedate();
		String afterdate = colgEvntQueryVo.getAfterdate();
		if (foredate != null && foredate.length() != 0) {
			if (afterdate != null && afterdate.length() != 0) {
				oriHql.append(" AND cg.eventDate BETWEEN '" + foredate + "' AND '" + afterdate + "'");
			} else {
				oriHql.append(" AND cg.eventDate >= '" + foredate + "'");
			}
		}
		oriHql.append(" ORDER BY cg.eventDate desc ");
		Query query = session.createQuery("SELECT COUNT(*) " + oriHql.toString());
		Object o = query.uniqueResult();
		int recordCount = 0;
		if (o != null) {
			recordCount = Integer.parseInt(String.valueOf(query.uniqueResult()));
		}
		resultMap.put("recordCount", recordCount);
		query = session.createQuery(oriHql.toString());
		resultMap.put("resultList", query.setFirstResult((pageIndex - 1) * pageSize).setMaxResults(pageSize).list());
		return resultMap;
	}

}
