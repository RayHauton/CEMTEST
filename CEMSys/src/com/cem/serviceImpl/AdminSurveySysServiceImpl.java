package com.cem.serviceImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cem.dao.AdminSurveySysDao;
import com.cem.pojo.Majorabilitycultivationquality;
import com.cem.pojo.Selfabilityquality;
import com.cem.pojo.User;
import com.cem.queryVO.AdminSurveyQueryVo;
import com.cem.service.AdminSurveySysService;

import jxl.Workbook;
import jxl.format.Colour;
import jxl.format.UnderlineStyle;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;


@Service
public class AdminSurveySysServiceImpl implements AdminSurveySysService {

	@Autowired
	AdminSurveySysDao adminSurveySysDao = null;
	@Autowired  
	private  HttpServletRequest request;  
	@Autowired  
	private  HttpServletResponse response; 
	
	List<String> listU = new ArrayList<>();
	List<String> listS = new ArrayList<>();
	List<String> listM = new ArrayList<>();
	public AdminSurveySysServiceImpl() {
		listU.add("真实姓名");
		listU.add("性别");
		listU.add("出生日期");
		listU.add("入学时间");
		listU.add("毕业时间");
		listS.add("任课教师敬业水平");
		listS.add("团队协作精神");
		listS.add("敬业精神");
		listS.add("专业基础知识");
		listS.add("知识面");
		listS.add("外语水平");
		listS.add("获取和应用新知识的能力");
		listS.add("独立分析解决问题的能力");
		listS.add("实践动手的能力");
		listS.add("创新能力");
		listS.add("人际沟通和组织协调能力");
		listS.add("语言文字表达能力");
		listS.add("心理承受能力和抗挫折能力");
		listM.add("任课教师敬业水平");
		listM.add("任课教师教学水平");
		listM.add("师生关系");
		listM.add("专业培养和社会契合度");
		listM.add("国际交流学习");
		listM.add("基础课程学习");
		listM.add("专业课程学习");
		listM.add("专业实验");
		listM.add("专业实习");
		listM.add("毕业（设计）论文");
		listM.add("教材选用");
		listM.add("专业竞赛活动");
		listM.add("校园学术讲座");
		listM.add("文娱活动");
		listM.add("体育健身类活动");
		listM.add("学风建设");
		listM.add("图书馆作用发挥");
		listM.add("辅导员工作");
		listM.add("后勤保障工作");
		listM.add("校友联络沟通工作");
		listM.add("生涯规划、就业指导");
		listM.add("心理疏导");
		listM.add("导师指导");
		listM.add("项目经验");
		listM.add("科研机会");
		listM.add("科研精神与学术道德");
	}
	
	
	@Override
	public List<Integer> searchSMCondition(AdminSurveyQueryVo adminSurveyQueryVo) {
		return adminSurveySysDao.searchSMCondition(adminSurveyQueryVo);
	}

	@Override
	public User searchUserByUserId(int userId) {
		return adminSurveySysDao.searchUserByUserId(userId);
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
		for (int i = 0; i < listU.size(); i++) {
			label = new Label(column++,2,listU.get(i),titleCellFormat);
			sheet.addCell(label);
		}
		if(sList.size()!=0&&mList.size()!=0){
			for (int i = 0; i < listS.size(); i++) {
				label = new Label(column++,2,listS.get(i),titleCellFormat);
				sheet.addCell(label);
			}
			for (int i = 0; i < listM.size(); i++) {
				label = new Label(column++,2,listM.get(i),titleCellFormat);
				sheet.addCell(label);
			}
		}else if(sList.size()==0){
			for (int i = 0; i < listM.size(); i++) {
				label = new Label(column++,2,listM.get(i),titleCellFormat);
				sheet.addCell(label);
			}
		}else if(mList.size()==0){
			for (int i = 0; i < listS.size(); i++) {
				label = new Label(column++,2,listS.get(i),titleCellFormat);
				sheet.addCell(label);
			}
		}
		//添加内容
		for (int i = 0; i < userList.size(); i++) {
			if(userList.get(i)!=null){
				String[] userArray = userList.get(i).toString().split(",");
				for (int k = 0; k < userArray.length; k++) {
					label = new Label(k,i+3,userArray[k],detCellFormat);
					sheet.addCell(label);
				}
			}
			if(sList.size()!=0&&sList.get(i)!=null){
				String[] sArray = sList.get(i).toString().split(",");
				for (int k = 0; k < sArray.length; k++) {
					label = new Label(k+5,i+3,sArray[k],detCellFormat);
					sheet.addCell(label);
				}
			}
			if(mList.size()!=0&&mList.get(i)!=null){
				int begin = 0;
				if(sList.size()==0)
					begin = 5;
				else
					begin = 18;
				String[] mArray = mList.get(i).toString().split(",");
				for (int k = 0; k < mArray.length; k++) {
					label = new Label(k+begin,i+3,mArray[k],detCellFormat);
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
		return adminSurveySysDao.searchAllUser();
	}

}
