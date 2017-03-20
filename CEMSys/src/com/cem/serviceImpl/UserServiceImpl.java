package com.cem.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cem.customPojo.UserBaseInfo;
import com.cem.dao.UserDao;
import com.cem.pojo.User;
import com.cem.queryVO.UserManageVo;
import com.cem.service.UserService;

/**
 * Created by RayHauton on 2017/1/25.
 */
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserDao userDao = null;

	
	
	/**
	 * @param classNo 班级号码
	 * @param truename 真实姓名
	 * @return 包含班级同学的一些信息
	 * @exception exception
	 * @author linhd
	 */
	@Override
	public List<UserBaseInfo> findClassMateByClasNo(String truename,String classNo) throws Exception {
		return userDao.findClassMateByClasNo(truename,classNo);
	}

	@Override
	public void insertUser(User user) throws Exception {
		/*
		 * 设置审核，删除标志位
		 */
		user.setCheckOut("0");
		user.setIsDeleted("0");
		userDao.insertUser(user);
	}

	@Override
	public User findUserByUserId(long userId) throws Exception {
		return userDao.findUserByUserId(userId);
	}

	@Override
	public User findUserByStudNum(String studNum, boolean passed) throws Exception {
		if (studNum.length() == 8)
			studNum = "0" + studNum;
		System.out.println(studNum);
		return userDao.findUserByStudNum(studNum, passed);
	}

	@Override
	public User findUserByUsername(String username, boolean passed) throws Exception {
		return userDao.findUserByUsername(username, passed);
	}

	@Override
	public User findUserByMobile(String mobile, boolean passed) throws Exception {
		return userDao.findUserByMobile(mobile, passed);
	}

	@Override
	public User finduserByEmail(String email, boolean passed) throws Exception {
		return userDao.finduserByEmail(email, passed);
	}

	@Override
	public User findIfUserExist(String username, String mobile, String studNum, String email) throws Exception {
		return userDao.findIfUserExist(username, mobile, studNum, email);
	}

	@Override
	public void updateUser(User user) throws Exception {
		userDao.updateUser(user);
	}

	@Override
	public Map<String, Object> findUsersFromUserManage(UserManageVo userManageVo) throws Exception {
		// // TODO Auto-generated method stub
		Map<String, Object> result = new HashMap<>();
		// if ("3".equals(userManageVo.getAudit())) {
		// userManageVo.setAudit("1");
		// result.put("approved",
		// userDao.findUsersFromUserManage(userManageVo));
		// userManageVo.setAudit("0");
		// result.put("disapproved",
		// userDao.findUsersFromUserManage(userManageVo));
		// } else
		if (userManageVo.getPageIndex() == null || "".equals(userManageVo.getPageIndex()))
			userManageVo.setPageIndex("1");
		if ("0".equals(userManageVo.getAudit())) {
			result.put("disapproved", userDao.findUsersFromUserManage(userManageVo));
			result.put("approved", null);
		} else {
			result.put("approved", userDao.findUsersFromUserManage(userManageVo));
			result.put("disapproved", null);
		}
		userManageVo.setRecordCount(String.valueOf(userDao.countUsers(userManageVo)));
		result.put("userManageVo", userManageVo);
		return result;
	}

	@Override
	public Map<String, Object> findUsersFromUserManageWithOut(UserManageVo userManageVo) throws Exception {
		Map<String, Object> result = new HashMap<>();
		String audit = userManageVo.getAudit();
		System.out.println(userManageVo.getPageSize());
		System.out.println(userManageVo.getPageIndex());
		int pageS = Integer.parseInt(userManageVo.getPageSize());
		int pageI;
		if (userManageVo.getPageIndex() == null || "".equals(userManageVo.getPageIndex())) {
			userManageVo.setPageIndex("1");
			pageI = 1;
		} else {
			pageI = Integer.parseInt(userManageVo.getPageIndex());
		}
		// if ("3".equals(audit)) {
		// result.put("approved", userDao.finddUsersFromUserManageWithOut("1",
		// pageS, pageI));
		// result.put("disapproved",
		// userDao.finddUsersFromUserManageWithOut("0", pageS, pageI));
		// userManageVo.setRecordCount(String.valueOf(userDao.countUsersWithOut(audit)));
		// result.put("userManageVo", userManageVo);
		// } else
		if ("0".equals(audit)) {
			result.put("disapproved", userDao.finddUsersFromUserManageWithOut("0", pageS, pageI));
			result.put("approved", null);
		} else if ("1".equals(audit)) {
			result.put("approved", userDao.finddUsersFromUserManageWithOut("1", pageS, pageI));
			result.put("disapproved", null);
		}
		userManageVo.setRecordCount(String.valueOf(userDao.countUsersWithOut(audit)));
		result.put("userManageVo", userManageVo);
		return result;

	}

	@Override
	public boolean deleteUser(User user) throws Exception {
		// TODO Auto-generated method stub
		if (user.getStudNumber().length() == 8)
			user.setStudNumber("0" + user.getStudNumber());
		User user2 = findUserByStudNum(user.getStudNumber(), false);
		if (user2 == null) {
			System.out.println("未找到");
			return false;
		} else {
			user2.setIsDeleted("1");
		}
		if (userDao.updateUser(user2))
			return true;
		else {
			return false;
		}
	}

	@Override
	public void checkUserStates(String[] studNumberArr, String[] auditArr) throws Exception {
		// TODO Auto-generated method stub
		for (int i = 0; i < studNumberArr.length; i++) {
			User user = userDao.findUserByStudNum(studNumberArr[i], false);
			if ("1".equals(auditArr[i]))
				user.setCheckOut("1");
			else
				user.setCheckOut("2");
			userDao.updateUser(user);
		}
	}

	@Override
	public List<User> findUserWithOut() throws Exception {
		return userDao.findUsersWithOut();
	}

	@Override
	public void downloadUsers(List<User> uList) throws Exception {
		userDao.dataToExcel(uList);
		userDao.download();

	}

}
