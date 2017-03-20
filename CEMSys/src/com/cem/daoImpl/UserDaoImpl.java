package com.cem.daoImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aspectj.weaver.ast.And;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.Where;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cem.dao.UserDao;
import com.cem.pojo.Majorabilitycultivationquality;
import com.cem.pojo.Selfabilityquality;
import com.cem.pojo.User;
import com.cem.queryVO.UserManageVo;

import jxl.Workbook;
import jxl.format.Colour;
import jxl.format.UnderlineStyle;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

/**
 * Created by RayHauton on 2017/1/25.
 */
@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void insertUser(User user) throws Exception {
		Session session = getSession();
		session.save(user);
	}

	@Override
	public User findUserByUserId(long userId) throws Exception {
		return null;
	}

	@Override
	public User findUserByStudNum(String studNum, boolean passed) throws Exception {
		Session session = getSession();
		String hql = null;
		if (passed) {// 如果查找已经通过审核的用户
			hql = "FROM User user WHERE user.studNumber=? and user.isDeleted=? and user.checkOut='1'";
		} else {
			hql = "FROM User user WHERE user.studNumber=? and user.isDeleted=?";
		}
		@SuppressWarnings("unchecked")
		List<User> users = session.createQuery(hql).setParameter(0, studNum).setParameter(1, "0").setFirstResult(0)
				.setMaxResults(1).list();
		return users.size() == 1 ? users.get(0) : null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public User findUserByUsername(String username, boolean passed) throws Exception {
		Session session = getSession();
		String hql = null;
		if (passed) {
			hql = "FROM User where username=? and isDeleted=? and checkOut='1'";
		} else {
			hql = "FROM User where username=? and isDeleted=?";
		}
		List<User> users = session.createQuery(hql).setParameter(0, username).setParameter(1, "0").setFirstResult(0)
				.setMaxResults(1).list();
		return users.size() == 1 ? users.get(0) : null;
	}

	@Override
	public User findUserByMobile(String mobile, boolean passed) throws Exception {
		Session session = getSession();
		String hql = null;
		if (passed) {
			hql = "FROM User where mobile=? and isDeleted=? and checkOut='1'";
		} else {
			hql = "FROM User where mobile=? and isDeleted=?";
		}
		@SuppressWarnings("unchecked")
		List<User> users = session.createQuery(hql).setParameter(0, mobile).setParameter(1, "0").setFirstResult(0)
				.setMaxResults(1).list();
		return users.size() == 1 ? users.get(0) : null;
	}

	@Override
	public User finduserByEmail(String email, boolean passed) throws Exception {
		Session session = getSession();
		String hql = null;
		if (passed) {
			hql = "FROM User where email=? and isDeleted=? and checkOut='1'";
		} else {
			hql = "FROM User where email=? and isDeleted=?";
		}
		@SuppressWarnings("unchecked")
		List<User> users = session.createQuery(hql).setParameter(0, email).setParameter(1, "0").setFirstResult(0)
				.setMaxResults(1).list();
		return users.size() == 1 ? users.get(0) : null;
	}

	@Override
	public User findIfUserExist(String username, String mobile, String studNum, String email) throws Exception {
		User user = null;
		if ((user = findUserByMobile(mobile, false)) != null) {
		} else if ((user = findUserByUsername(username, false)) != null) {
		} else if ((user = finduserByEmail(email, false)) != null) {
		} else if ((user = findUserByStudNum(studNum, false)) != null) {
		} else {
		}
		return user;
	}

	@Override
	public boolean updateUser(User user) throws Exception {
		Session session = getSession();
		session.merge(user);
		session.flush();
		return true;
	}

	@Override
	public List<Object> findUsersFromUserManage(UserManageVo userManageVo) throws Exception {
		System.out.println("dao层开始");
		Session session = getSession();
		String studNumber = userManageVo.getStudNumber();
		String truename = userManageVo.getTruename();
		String entranceDate = userManageVo.getEntranceDate();
		String majorId = userManageVo.getMajorId();
		String degreeId = userManageVo.getDegreeId();
		String passed = userManageVo.getAudit();
		int pageSize = Integer.parseInt(userManageVo.getPageSize());
		int pageIndex;
		if (userManageVo.getPageIndex() == null || "".equals(userManageVo.getPageIndex()))
			pageIndex = 1;
		else {
			pageIndex = Integer.parseInt(userManageVo.getPageIndex());
		}
		System.out.println(studNumber);
		System.out.println(truename);
		System.out.println(entranceDate);
		System.out.println(majorId);
		System.out.println(degreeId);

		if ((studNumber == null || "".equals(studNumber)) && (truename == null || "".equals(truename))
				&& (entranceDate == null || "".equals(entranceDate)) && (majorId == null || "".equals(majorId))
				&& (degreeId == null || "".equals(degreeId))) {
			System.out.println("错误查询");
			return null;
		}
		StringBuilder hql = new StringBuilder(
				"select u.truename,u.studNumber,m.majorName,u.mobile,u.email,u.entranceDate,u.graduateDate from User u join Schoolexperience s on (u.schoolExperienceId=s.schooleExperienceId) join Major m on (s.majorId=m.majorId) where u.isDeleted  = '0' ");
		if ("0".equals(passed))
			hql.append("And u.checkOut='0' ");
		else if ("1".equals(passed)) {
			hql.append("And u.checkOut='1' ");
		}
		if (studNumber != null && !("".equals(studNumber)))
			hql.append("And u.studNumber= '" + studNumber+"'");
		else {
			if (truename != null && !("".equals(truename))) {
				hql.append("And u.truename = '" + truename+"'");
			}
			if (entranceDate != null && !("".equals(entranceDate))) {
				hql.append("And u.entranceDate = '" + entranceDate+"'");
			}
			if (majorId != null && !("".equals(majorId)))
				hql.append("And s.majorId = '" + majorId + "'");
			if (degreeId != null && !("".equals(degreeId)))
				hql.append("And s.degreeId  = '" + degreeId + "'");
		}
		System.out.println(hql.toString());
		return session.createSQLQuery(hql.toString()).setFirstResult((pageIndex - 1) * pageSize).setMaxResults(pageSize)
				.list();

	}

	@Override
	public int countUsers(UserManageVo userManageVo) throws Exception {
		Session session = getSession();
		String studNumber = userManageVo.getStudNumber();
		String truename = userManageVo.getTruename();
		String entranceDate = userManageVo.getEntranceDate();
		String majorId = userManageVo.getMajorId();
		String degreeId = userManageVo.getDegreeId();
		String passed = userManageVo.getAudit();
		System.out.println(studNumber);
		System.out.println(truename);
		System.out.println(entranceDate);
		System.out.println(majorId);
		System.out.println(degreeId);

		if ((studNumber == null || "".equals(studNumber)) && (truename == null || "".equals(truename))
				&& (entranceDate == null || "".equals(entranceDate)) && (majorId == null || "".equals(majorId))
				&& (degreeId == null || "".equals(degreeId)) ) {
			System.out.println("错误查询");
			return 0;
		}
		StringBuilder hql = new StringBuilder("from User u join Schoolexperience s on (u.schoolExperienceId=s.schooleExperienceId) join Major m on (s.majorId=m.majorId) where u.isDeleted  = '0' ");
		if ("0".equals(passed))
			hql.append("And u.checkOut='0' ");
		else if ("1".equals(passed)) {
			hql.append("And u.checkOut='1' ");
		}
		if (studNumber != null && !("".equals(studNumber)))
			hql.append("And u.studNumber= '" + studNumber+"'");
		else {
			if (truename != null && !("".equals(truename))) {
				hql.append("And u.truename = '" + truename+"'");
			}
			if (entranceDate != null && !("".equals(entranceDate))) {
				hql.append("And u.entranceDate = '" + entranceDate+"'");
			}
			if (majorId != null && !("".equals(majorId)))
				hql.append("And s.majorId = '" + majorId + "'");
			if (degreeId != null && !("".equals(degreeId)))
				hql.append("And s.degreeId  = '" + degreeId + "'");
		}
		System.out.println(hql.toString());
		return Integer
				.parseInt(String.valueOf(session.createSQLQuery("SELECT COUNT(userId) " + hql.toString()).uniqueResult()));
	}

	/* 将数据转为Excel */
	public void dataToExcel(List<User> userList,HttpServletRequest request) throws Exception {
		// 获取文件地址
		String realPath = request.getServletContext().getRealPath("/") + "tempFile";
		// 创建父目录
		File fileupload = new File(realPath);
		if (!fileupload.exists()) {
			fileupload.mkdir();
		}
		// 创建子文件
		File saveFile = new File(realPath, "tempFlie.xls");

		Label label = null;
		// 创建工作簿
		WritableWorkbook workbook = Workbook.createWorkbook(saveFile);
		// 创建工作表
		WritableSheet sheet = workbook.createSheet("Sheet1", 0);
		// 样式表
		// 表头样式
		WritableFont headerFont = new WritableFont(WritableFont.ARIAL, 12, WritableFont.BOLD, false,
				UnderlineStyle.NO_UNDERLINE, Colour.BLUE);
		WritableCellFormat headerCellFormat = new WritableCellFormat(headerFont);
		// 标题样式
		WritableFont titleFont = new WritableFont(WritableFont.ARIAL, 12, WritableFont.BOLD, false,
				UnderlineStyle.NO_UNDERLINE, Colour.BLACK);
		WritableCellFormat titleCellFormat = new WritableCellFormat(titleFont);
		// 内容样式
		WritableFont detFont = new WritableFont(WritableFont.ARIAL, 12, WritableFont.NO_BOLD, false,
				UnderlineStyle.NO_UNDERLINE, Colour.BLACK);
		WritableCellFormat detCellFormat = new WritableCellFormat(detFont);

		// 添加标题
		// label构造函数第一为列坐标，第二个为行坐标，第三个为内容
		int column = 0;
		label = new Label(column++, 0, "用户名", titleCellFormat);
		sheet.addCell(label);
		label = new Label(column++, 0, "真实姓名", titleCellFormat);
		sheet.addCell(label);
		label = new Label(column++, 0, "性别", titleCellFormat);
		sheet.addCell(label);
		label = new Label(column++, 0, "学号", titleCellFormat);
		sheet.addCell(label);
		label = new Label(column++, 0, "出生日期", titleCellFormat);
		sheet.addCell(label);
		label = new Label(column++, 0, "手机号", titleCellFormat);
		sheet.addCell(label);
		label = new Label(column++, 0, "邮箱", titleCellFormat);
		sheet.addCell(label);
		label = new Label(column++, 0, "地址", titleCellFormat);
		sheet.addCell(label);
		label = new Label(column++, 0, "入学时间", titleCellFormat);
		sheet.addCell(label);
		label = new Label(column++, 0, "毕业时间", titleCellFormat);
		sheet.addCell(label);
		label = new Label(column++, 0, "审核状态", titleCellFormat);
		sheet.addCell(label);

		// 添加内容
		for (int i = 0; i < userList.size(); i++) {
			if (userList.get(i) != null) {
				String[] userArray = userList.get(i).toString().split(",");
				int k = 0;
				for (; k < userArray.length; k++) {
					label = new Label(k, i + 1, userArray[k], detCellFormat);
					sheet.addCell(label);
				}
				if (userList.get(i).getCheckOut().equals("1")) {
					label = new Label(k, i + 1, "审核通过", detCellFormat);
				} else if (userList.get(i).getCheckOut().equals("0")) {
					label = new Label(k, i + 1, "未审核", detCellFormat);
				} else {
					label = new Label(k, i + 1, "未通过审核", detCellFormat);
				}
				sheet.addCell(label);
			}
		}
		// 设置列的宽度
		for (int j2 = 0; j2 < 49; j2++) {
			sheet.setColumnView(j2, 20);
		}

		workbook.write();
		workbook.close();
	}

	public void download(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String path = request.getServletContext().getRealPath("/") + "tempFile/";
		File file = new File(path + "tempFlie.xls");
		// 根据当前时期生成下载的默认文件名
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String dateNowStr = sdf.format(d);

		// 设置相应类型application/octet-stream
		response.setContentType("application/x-msdownload");
		// 设置头信息
		response.setHeader("Content-Disposition", "attachment;filename=\"" + dateNowStr + ".xls\"");
		InputStream inputStream = new FileInputStream(file);
		ServletOutputStream ouputStream = response.getOutputStream();
		byte b[] = new byte[1024];
		int n;
		while ((n = inputStream.read(b)) != -1) {
			ouputStream.write(b, 0, n);
		}
		// 关闭流、释放资源
		ouputStream.close();
		inputStream.close();
		file.delete();
	}

	@Override
	public List<User> findUsersWithOut() throws Exception {
		Session session = getSession();
		String sql = "from User u where u.isDeleted  = '0' ";
		List<User> uList = session.createQuery(sql).setFirstResult(0).list();
		return uList;
	}

	@Override
	public List<Object> finddUsersFromUserManageWithOut(String passed, int pageSize, int pageIndex) throws Exception {
		Session session = getSession();
		String hql = null;
		System.out.println(passed);
		if ("1".equals(passed))
			hql = "select u.truename,u.studNumber,m.majorName,u.mobile,u.email,u.entranceDate,u.graduateDate "
					+ "from User u join SchoolExperience s on (u.schoolExperienceId=s.schooleExperienceId) join Major m on (s.majorId=m.majorId) "
					+ "where u.isDeleted  = '0' and u.checkOut = '1' ";
		else if ("3".equals(passed)) {
			hql = "select u.truename,u.studNumber,m.majorName,u.mobile,u.email,u.entranceDate,u.graduateDate "
					+ "from User u join SchoolExperience s on (u.schoolExperienceId=s.schooleExperienceId) join Major m on (s.majorId=m.majorId) "
					+ "where u.isDeleted  = '0' ";
		} else if ("0".equals(passed)) {
			hql = "select u.truename,u.studNumber,m.majorName,u.mobile,u.email,u.entranceDate,u.graduateDate "
					+ "from User u join SchoolExperience s on (u.schoolExperienceId=s.schooleExperienceId) join Major m on (s.majorId=m.majorId) "
					+ "where u.isDeleted  = '0' and u.checkOut = '0' ";
		}
		return session.createSQLQuery(hql).setFirstResult((pageIndex - 1) * pageSize).setMaxResults(pageSize).list();
	}

	@Override
	public int countUsersWithOut(String passed) throws Exception {
		Session session = getSession();
		String hql = null;
		if ("1".equals(passed))
			hql = "from User u where u.isDeleted  = '0' and u.checkOut = '1' ";
		// else if ("3".equals(passed)) {
		// hql = "from User u where u.isDeleted = '0' ";
		// }
		else if ("0".equals(passed)) {
			hql = "from User u where u.isDeleted  = '0' and u.checkOut = '0' ";
		}
		return Integer
				.parseInt(String.valueOf(session.createQuery("SELECT COUNT(*) " + hql.toString()).uniqueResult()));
	}

}
