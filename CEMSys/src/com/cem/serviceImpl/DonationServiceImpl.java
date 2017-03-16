package com.cem.serviceImpl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cem.customPojo.UserCustom;
import com.cem.dao.DonationDao;
import com.cem.pojo.Donation;
import com.cem.queryVO.DonationQueryVo;
import com.cem.service.DonationService;

@Service
public class DonationServiceImpl implements DonationService {

	@Autowired
	private DonationDao donationDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cem.service.DonationService#update(com.cem.pojo.Donation) 更新记录信息
	 */
	@Override
	public void update(Donation donation) throws Exception {
		donation.setIsDeleted("0");
		donationDao.update(donation);//其实调用的是merge方法 不是update API
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.cem.service.DonationService#findAll(com.cem.queryVO.DonationQueryVo)
	 * 查询满足条件的全部记录（实现了分页）
	 */
	@Override
	public Map<String, Object> findAll(DonationQueryVo queryVo) throws Exception {
		return donationDao.findAll(queryVo);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cem.service.DonationService#findDonorInfo(com.cem.customPojo.
	 * UserCustom) 查询捐赠人的部分信息
	 */
	@Override
	public UserCustom findDonorInfo(UserCustom userCustom) throws Exception {
		return donationDao.findDonorInfo(userCustom);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cem.service.DonationService#insert(com.cem.pojo.Donation) 新增记录
	 */
	@Override
	public void insert(Donation donation) throws Exception {
		donation.setIsDeleted("0");
		donationDao.insert(donation);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cem.service.DonationService#delete(java.lang.Integer) 删除捐赠记录
	 */
	@Override
	public void delete(Integer donationId) throws Exception {
		Donation donation = donationDao.findById(donationId);
		donation.setIsDeleted("1");
		donationDao.delete(donation);
	}

}
