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

	@Override
	public void add(Collegeevent collegeevent) throws Exception {
		Session session = getSession();
		session.save(collegeevent);
	}

	@Override
	public Map<String, Object> findAll(CollegeEventQueryVo colgEvntQueryVo) throws Exception {
		Session session = getSession();
		Map<String,Object> resultMap = new HashMap<>(2);
		StringBuilder oriHql = new StringBuilder("FROM Collegeevent cg WHERE cg.isDeleted='0'");
		/*
		 * 根据查询条件组装查询语句
		 */
		int pageIndex = colgEvntQueryVo.getPageIndex();
		int pageSize = colgEvntQueryVo.getPageSize();
		String foredate = colgEvntQueryVo.getForedate();
		String afterdate = colgEvntQueryVo.getAfterdate();
		if(foredate!=null && foredate.length()!=0){
			if(afterdate!=null && afterdate.length()!=0){
				oriHql.append(" AND cg.eventDate BETWEEN '"+foredate+"' AND '"+afterdate+"'");
			}else{
				oriHql.append(" AND cg.eventDate >= '"+foredate+"'");
			}
		}
		oriHql.append(" ORDER BY cg.eventDate desc ");
		Query query = session.createQuery("SELECT COUNT(*) "+oriHql.toString());
		Object o = query.uniqueResult();
		int recordCount=0;
		if(o!=null){
			recordCount=Integer.parseInt(String.valueOf((Long)query.uniqueResult()));
		}
		resultMap.put("recordCount", recordCount);
		query = session.createQuery(oriHql.toString());
		resultMap.put("resultList",query.setFirstResult((pageIndex-1)*pageSize).setMaxResults(pageSize).list());
		return resultMap;
	}

}
