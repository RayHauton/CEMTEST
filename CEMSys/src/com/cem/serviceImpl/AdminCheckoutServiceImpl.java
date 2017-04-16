package com.cem.serviceImpl;

import static org.hamcrest.CoreMatchers.instanceOf;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cem.dao.AdminCheckoutDao;
import com.cem.pojo.User;
import com.cem.service.AdminCheckoutService;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Single;

@Service
public class AdminCheckoutServiceImpl implements AdminCheckoutService{

	@Autowired
	private AdminCheckoutDao adminCheckoutDao = null;
	
	@Override
	public List<User> getUncheckoutUser() throws Exception {
		return adminCheckoutDao.getUncheckoutUser();
	}

	@Override
	public List<String> checkouting(User user) throws Exception {
		LinkedList<String> resultList = new LinkedList<String>();
		//将原有的信息添加至List中
		resultList.add(user.getUsername());
		resultList.add(user.getTruename());
		resultList.add(user.getStudNumber());
		resultList.add(user.getEntranceDate().substring(0,4));
		
		//获取该用户名字在学生名单中对应的ID号，存在同名同姓的情况，故用List
		List<Integer> studentlist = adminCheckoutDao.getStudentByStuName(user.getTruename());
		if(!studentlist.isEmpty()){
			resultList.addLast(user.getTruename());
			resultList.add(2, "yes");
			int tableId = 0;
			
			
			//获取注册信息在学生名单中的学号，避免随机输入的学号恰好在数据库中出现
			if(studentlist.size()==1){//如果注册信息中的名字与学生表中名字仅有一个对应，则根据学生名字获取学生的学号
				String stuID = adminCheckoutDao.getStudentById(studentlist.get(0));
				if(user.getStudNumber().equals(stuID))
					resultList.add(4,"yes"); 
				else
					resultList.add(4,"No");
				String temp = String.valueOf(stuID);
				if(temp.length()<9) temp="0"+temp;
				resultList.addLast(temp);		
			}else if(studentlist.size()>1){//查询到符合名字的人数不止一个人，通过名字获取学生的学号，如果学生中获得的学号都相同，表明该同学很可能为同一个人，为留级生，故数据中有两条记录
				List<String> studentIdList = adminCheckoutDao.getUseridByTruename(user.getTruename());
				boolean flag = true;
				String temp = studentIdList.get(0);
				for (String string : studentIdList) {
					if(!temp.equals(string))
						flag = false;
				}
				if(flag){
					if(!("".equals(user.getUserId()))&&temp.equals(user.getUserId()))
						resultList.add(4,"yes"); 
					else
						resultList.add(4,"No");
					resultList.addLast(temp);
				}
				else{
					resultList.add(4,"No");
					resultList.addLast("无法匹配学号");
				}
			}else if(!user.getStudNumber().equals("")){//注册信息中有学号，若该ID号在studentList中，则说明学号正确存在。
				tableId = adminCheckoutDao.getStudentByStuId(user.getStudNumber());
				if(tableId!=0&&studentlist.contains(tableId)){
					resultList.add(4,"yes");
					resultList.addLast(String.valueOf(user.getStudNumber()));					
				}else {
					resultList.add(4,"No");
					resultList.addLast("无法匹配学号");					
				}
			}else{//若上述三种情况都不满足，则说明学生名单中存在两个同名同姓的学生且不是同一个人，故无法匹配到学号。
				resultList.add(4,"No"); 
				resultList.addLast("无法匹配学号");	
			}
			
			
			//获取注册信息在学生名单中的入学时间
			if(studentlist.size()==1){//如果注册信息中的名字与学生表中名字仅有一个对应，则根据学生名字获取学生的入学时间
				List<String> entranceDate = adminCheckoutDao.getEntranceDateBystuName(user.getTruename());
				if(user.getEntranceDate().substring(0,4).equals(entranceDate.get(0)))
					resultList.add(6,"yes"); 
				else
					resultList.add(6,"No");
				resultList.addLast(entranceDate.get(0));
			}else if(tableId==0){//若tableId为0，则表示数据库中不存在该学号，通过名字获取该学生的入学时间
				List<String> entranceDate = adminCheckoutDao.getEntranceDateBystuName(user.getTruename());
				if(entranceDate.contains(user.getEntranceDate().substring(0,4))){
					resultList.add(6,"yes");
					resultList.addLast(user.getEntranceDate().substring(0,4));
				}else if(entranceDate.size()>1){
					boolean flag = true;
					String temp = entranceDate.get(0);
					for (String string : entranceDate) {
						if(!temp.equals(string))
							flag = false;
					}
					if(flag){
						if(temp.equals(user.getEntranceDate().substring(0,4)))
							resultList.add(6,"yes");
						else
							resultList.add(6,"No");
						resultList.addLast(temp);
					}else{
						resultList.add(6,"No");
						resultList.addLast("无对应入学时间");
					}
				}else{
					resultList.add(6,"No");
					resultList.addLast("无对应入学时间");
				}
			}else{//若ID号不为0，则可以直接通过tableId获取其入学时间
				String entranceDate = adminCheckoutDao.getEntranceDateByStuid(tableId);
				if(entranceDate.equals(user.getEntranceDate().substring(0,4))){
					resultList.add(6,"yes");
					resultList.addLast(user.getEntranceDate().substring(0,4));
				}
				else{
					resultList.add(6,"No");
					resultList.addLast("无对应入学时间");
				}
			}
			
		}
		else{//若用户名字在学生名单中都是不存在的，则其所有信息为错误信息
			resultList.add(2, "No");
			resultList.add(4, "No");
			resultList.add(6, "No");
			resultList.add("该姓名不存在");
			resultList.add("该姓名不存在");
			resultList.add("该姓名不存在");
		}
		return resultList;
	}

	@Override
	public void Audit(String flag, String username) throws Exception {
		adminCheckoutDao.Audit(flag, username);
	}

	@Override
	public String getEmailByUsername(String username) throws Exception {
		return adminCheckoutDao.getEmailByUsername(username);
	}

}
