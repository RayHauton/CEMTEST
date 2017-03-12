package com.cem.serviceImpl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.cem.dao.CollegeEventDao;
import com.cem.pojo.Collegeevent;
import com.cem.queryVO.CollegeEventQueryVo;
import com.cem.service.CollegeEventService;

@Service
public class CollegeEventServiceImpl implements CollegeEventService {
	@Autowired
	private CollegeEventDao collegeEventDao;
	@Value("${defaultPageSize}")
	private Integer pageSizeDefault;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cem.service.CollegeEventService#findById(java.lang.Integer)
	 * 根据ID查询学员事件记录
	 */
	@Override
	public Collegeevent findById(Integer eventId) throws Exception {
		return collegeEventDao.findById(eventId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.cem.service.CollegeEventService#update(com.cem.pojo.Collegeevent)
	 * 更新学院事件记录
	 */
	@Override
	public void merge(Collegeevent collegeevent) throws Exception {
		collegeEventDao.merge(collegeevent);
	}

	@Override
	public void add(Collegeevent collegeevent) throws Exception {
		/*
		 * 对将要被持久化的pojo进行业务处理
		 */
		collegeevent.setIsDeleted("0");
		collegeEventDao.add(collegeevent);
	}

	@Override
	public Map<String, Object> findAll(CollegeEventQueryVo colgEvntQueryVo) throws Exception {
		if (colgEvntQueryVo.getPageIndex() == null) {
			colgEvntQueryVo.setPageIndex(1);
		}
		if (colgEvntQueryVo.getPageSize() == null) {
			colgEvntQueryVo.setPageSize(pageSizeDefault);
		}
		return collegeEventDao.findAll(colgEvntQueryVo);
	}

}
