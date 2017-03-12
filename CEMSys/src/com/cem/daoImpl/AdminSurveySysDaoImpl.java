package com.cem.daoImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cem.dao.AdminSurveySysDao;
import com.cem.pojo.Majorabilitycultivationquality;
import com.cem.pojo.Selfabilityquality;
import com.cem.pojo.User;

import jxl.Workbook;
import jxl.format.Colour;
import jxl.format.UnderlineStyle;
import jxl.write.DateFormat;
import jxl.write.DateTime;
import jxl.write.Label;
import jxl.write.NumberFormat;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

@Repository
public class AdminSurveySysDaoImpl implements AdminSurveySysDao {
	@Autowired  
	private  HttpServletRequest request;  
	@Autowired  
	private  HttpServletResponse response;  

	List<String> list = new ArrayList<>();
	public AdminSurveySysDaoImpl() {
		//在构造函数中将题号与对应的选项对应起来
		list.add("");
		list.add("gumptionAndAchvConscious");
		list.add("companyCooperation");
		list.add("professionalism");
		list.add("majorBaseKnowledge");
		list.add("knowledgeWidth");
		list.add("foreignLanguage");
		list.add("acquireAndApplyKnowledge");
		list.add("selfDealProblem");
		list.add("practiceAndHandsOn");
		list.add("motivationAbility");
		list.add("communicationAndOrganizeAbility");
		list.add("wordsExpression");
		list.add("psychologyBearAndAntiFrustration");
		list.add("teacherProfessionalismLevel");
		list.add("teacherTeachingLevel");
		list.add("relationshipOfTcherAndStud");
		list.add("majorCultivationTargetAndSocialFit");
		list.add("internationalCommunicationLearning");
		list.add("baseCourseLearning");
		list.add("majorCourseLearning");
		list.add("majorExperiment");
		list.add("majorInternship");
		list.add("graduationDesign");
		list.add("textbookUsed");
		list.add("majorCompetitionActivity");
		list.add("schoolAcademicLecture");
		list.add("recreationalActivities");
		list.add("physicalFitness");
		list.add("learningAtmosphereConstruction");
		list.add("libraryEffect");
		list.add("instructorWorking");
		list.add("logisticServiceWorking");
		list.add("fellowConnectionWorking");
		list.add("careerPlanningAndEmploymentGuidance");
		list.add("psychologyGrooming");
		list.add("tutorGuidance");
		list.add("projectExperience");
		list.add("scientificResearchOpportunity");
		list.add("scienReschSpiritAndAcademicMoral");
	}

	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public List<Integer> searchSMCondition(String[] titleNum, String[] scoreNum) {
		Session session = getSession();
		//原始SQL语句
		String sql = "select m.userId from Majorabilitycultivationquality m join Selfabilityquality s on (m.userId=s.userId)"
					+ " where m.isDeleted = '0' and s.isDeleted = '0' ";
		//根据题号拼接字符串
		for (int i = 0; i < scoreNum.length; i++) {
			int temp = Integer.valueOf(titleNum[i]);
			if(temp<13)
				sql = sql + " and s."+ list.get(temp)+" = '"+ scoreNum[i]+"'";
			else
				sql = sql + " and m."+ list.get(temp)+" = '"+ scoreNum[i]+"'";
		}
		Query query = session.createSQLQuery(sql);
		List<Integer> queryList = (List<Integer>) query.list();
		return queryList;
	}

	public User searchUserByUserId(int userId){
		Session session = getSession();
		User user = (User) session.get(User.class, userId);
		if(user!=null)
			return user;
		else
			return null;
	}

	
	public void dataToExcel(List<User> userList,List<Selfabilityquality> sList,List<Majorabilitycultivationquality> mList) throws Exception {
		String realPath = request.getServletContext().getRealPath("/") + "tempFile";
		File fileupload = new File(realPath);
		if(!fileupload.exists()){
			fileupload.mkdir();
		}
		File saveFile = new File(realPath,"tempFlie.xls");
		Label label = null;
		WritableWorkbook workbook = Workbook.createWorkbook(saveFile);
		WritableSheet sheet = workbook.createSheet("Sheet1", 0);
		//样式表
		//表头样式
		WritableFont headerFont = new WritableFont(WritableFont.ARIAL,12,WritableFont.BOLD,false,UnderlineStyle.NO_UNDERLINE,Colour.BLUE);
		WritableCellFormat headerCellFormat = new WritableCellFormat(headerFont);
		//标题样式
		WritableFont titleFont = new WritableFont(WritableFont.ARIAL,12,WritableFont.BOLD,false,UnderlineStyle.NO_UNDERLINE,Colour.BLACK);
		WritableCellFormat titleCellFormat = new WritableCellFormat(titleFont);
		//内容样式
		WritableFont detFont = new WritableFont(WritableFont.ARIAL,12,WritableFont.NO_BOLD,false,UnderlineStyle.NO_UNDERLINE,Colour.BLACK);
		WritableCellFormat detCellFormat = new WritableCellFormat(detFont);
		
		//添加标题
		int column = 0;
		label = new Label(column++,2,"用户名",titleCellFormat);
		sheet.addCell(label);
		label = new Label(column++,2,"真实姓名",titleCellFormat);
		sheet.addCell(label);
		label = new Label(column++,2,"性别",titleCellFormat);
		sheet.addCell(label);
		label = new Label(column++,2,"学号",titleCellFormat);
		sheet.addCell(label);
		label = new Label(column++,2,"出生日期",titleCellFormat);
		sheet.addCell(label);
		label = new Label(column++,2,"手机号",titleCellFormat);
		sheet.addCell(label);
		label = new Label(column++,2,"邮箱",titleCellFormat);
		sheet.addCell(label);
		label = new Label(column++,2,"地址",titleCellFormat);
		sheet.addCell(label);
		label = new Label(column++,2,"入学时间",titleCellFormat);
		sheet.addCell(label);
		label = new Label(column++,2,"毕业时间",titleCellFormat);
		sheet.addCell(label);
		label = new Label(column++,2,"任课教师敬业水平",titleCellFormat);
		sheet.addCell(label);
		label = new Label(column++,2,"团队协作精神",titleCellFormat);
		sheet.addCell(label);
		label = new Label(column++,2,"敬业精神",titleCellFormat);
		sheet.addCell(label);
		label = new Label(column++,2,"专业基础知识",titleCellFormat);
		sheet.addCell(label);
		label = new Label(column++,2,"知识面",titleCellFormat);
		sheet.addCell(label);
		label = new Label(column++,2,"外语水平",titleCellFormat);
		sheet.addCell(label);
		label = new Label(column++,2,"获取和应用新知识的能力",titleCellFormat);
		sheet.addCell(label);
		label = new Label(column++,2,"独立分析解决问题的能力",titleCellFormat);
		sheet.addCell(label);
		label = new Label(column++,2,"实践动手的能力",titleCellFormat);
		sheet.addCell(label);
		label = new Label(column++,2,"创新能力",titleCellFormat);
		sheet.addCell(label);
		label = new Label(column++,2,"人际沟通和组织协调能力",titleCellFormat);
		sheet.addCell(label);
		label = new Label(column++,2,"语言文字表达能力",titleCellFormat);
		sheet.addCell(label);
		label = new Label(column++,2,"心理承受能力和抗挫折能力",titleCellFormat);
		sheet.addCell(label);
		label = new Label(column++,2,"任课教师敬业水平",titleCellFormat);
		sheet.addCell(label);
		label = new Label(column++,2,"任课教师教学水平",titleCellFormat);
		sheet.addCell(label);
		label = new Label(column++,2,"师生关系",titleCellFormat);
		sheet.addCell(label);
		label = new Label(column++,2,"专业培养和社会契合度",titleCellFormat);
		sheet.addCell(label);
		label = new Label(column++,2,"国际交流学习",titleCellFormat);
		sheet.addCell(label);
		label = new Label(column++,2,"基础课程学习",titleCellFormat);
		sheet.addCell(label);
		label = new Label(column++,2,"专业课程学习",titleCellFormat);
		sheet.addCell(label);
		label = new Label(column++,2,"专业实验",titleCellFormat);
		sheet.addCell(label);
		label = new Label(column++,2,"专业实习",titleCellFormat);
		sheet.addCell(label);
		label = new Label(column++,2,"毕业（设计）论文",titleCellFormat);
		sheet.addCell(label);
		label = new Label(column++,2,"教材选用",titleCellFormat);
		sheet.addCell(label);
		label = new Label(column++,2,"专业竞赛活动",titleCellFormat);
		sheet.addCell(label);
		label = new Label(column++,2,"校园学术讲座",titleCellFormat);
		sheet.addCell(label);
		label = new Label(column++,2,"文娱活动",titleCellFormat);
		sheet.addCell(label);
		label = new Label(column++,2,"体育健身类活动",titleCellFormat);
		sheet.addCell(label);
		label = new Label(column++,2,"学风建设",titleCellFormat);
		sheet.addCell(label);
		label = new Label(column++,2,"图书馆作用发挥",titleCellFormat);
		sheet.addCell(label);
		label = new Label(column++,2,"辅导员工作",titleCellFormat);
		sheet.addCell(label);
		label = new Label(column++,2,"后勤保障工作",titleCellFormat);
		sheet.addCell(label);
		label = new Label(column++,2,"校友联络沟通工作",titleCellFormat);
		sheet.addCell(label);
		label = new Label(column++,2,"生涯规划、就业指导",titleCellFormat);
		sheet.addCell(label);
		label = new Label(column++,2,"心理疏导",titleCellFormat);
		sheet.addCell(label);
		label = new Label(column++,2,"导师指导",titleCellFormat);
		sheet.addCell(label);
		label = new Label(column++,2,"项目经验",titleCellFormat);
		sheet.addCell(label);
		label = new Label(column++,2,"科研机会",titleCellFormat);
		sheet.addCell(label);
		label = new Label(column++,2,"科研精神与学术道德",titleCellFormat);
		sheet.addCell(label);
		
		//添加内容
		for (int i = 0; i < userList.size(); i++) {
			if(userList.get(i)!=null){
				String[] userArray = userList.get(i).toString().split(",");
				for (int k = 0; k < userArray.length; k++) {
					label = new Label(k,i+3,userArray[k],detCellFormat);
					sheet.addCell(label);
				}
			}
			if(sList.get(i)!=null){
				String[] sArray = sList.get(i).toString().split(",");
				for (int k = 0; k < sArray.length; k++) {
					label = new Label(k+10,i+3,sArray[k],detCellFormat);
					sheet.addCell(label);
				}
			}
			if(mList.get(i)!=null){
				String[] mArray = mList.get(i).toString().split(",");
				for (int k = 0; k < mArray.length; k++) {
					label = new Label(k+23,i+3,mArray[k],detCellFormat);
					sheet.addCell(label);
				}
			}
		}
		
		//设置列的宽度
		for (int j2 = 0; j2 < 49; j2++) {
			sheet.setColumnView(j2, 20);
		}
		
		workbook.write();
		workbook.close();
	}

	public void download() throws Exception {
		String path = request.getServletContext().getRealPath("/") + "tempFile/";
		File file = new File(path + "tempFlie.xls");
		//根据当前时期生成下载的默认文件名
		Date d = new Date();  
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");  
        String dateNowStr = sdf.format(d);  
		
		//设置相应类型application/octet-stream
		response.setContentType("application/x-msdownload");
		//设置头信息
		response.setHeader("Content-Disposition", "attachment;filename=\""+dateNowStr+".xls\"");
		InputStream inputStream = new FileInputStream(file);
		ServletOutputStream ouputStream = response.getOutputStream();
		byte b[] = new byte[1024];
		int n ;
		while((n = inputStream.read(b)) != -1){
			ouputStream.write(b,0,n);
		}
		//关闭流、释放资源
		ouputStream.close();
		inputStream.close();
		file.delete();
	}

	@Override
	public String[] searchAllUser() throws Exception {
		Session session = getSession();
		String hql = "select u.userId from User u";
		Query query = session.createSQLQuery(hql);
		List<Object> queryList = (List<Object>)query.list();
		String[] userIds = new String[queryList.size()];
		for (int i = 0; i < queryList.size(); i++)
			userIds[i] = String.valueOf(queryList.get(i));
		return userIds;
	}

}
