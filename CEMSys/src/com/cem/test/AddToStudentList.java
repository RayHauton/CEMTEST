package com.cem.test;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class AddToStudentList {

	@Test
	public void addData() throws BiffException, IOException {
		Workbook workbook = Workbook.getWorkbook(new File("C:/Users/nc硪fl/Desktop/04级-12级毕业生数据/04.xls"));
		Sheet sheet = workbook.getSheet(0);// 获取到第一个表格
		for (int i = 2; i < sheet.getRows()&&sheet.getCell(1, i).getContents()!=""; i++) {
			String id = sheet.getCell(0, i).getContents();
			String name = sheet.getCell(1, i).getContents();
			String classNo = sheet.getCell(2, i).getContents();
			String gender = sheet.getCell(3, i).getContents();
			String entrance = "20" + id.substring(2, 4);
			System.out.println(id + "   " + entrance + "   "+classNo+"   "+ name+"   "+gender);
		}
		workbook.close();
	}

	@Test
	public void addDataJdbc () throws Exception {
		String driverName = "com.mysql.jdbc.Driver";
		String dbURL = "jdbc:mysql://localhost:3306/cemsys";
		String userName = "root";
		String userPwd = "123456";
		Class.forName(driverName);
		Connection dbConn = DriverManager.getConnection(dbURL, userName, userPwd);
		for (int j = 4; j < 15; j++) {
			String a = String.format("%02d", j);
			String path = "C:/Users/nc硪fl/Desktop/04级-12级毕业生数据/"+a+".xls" ;
			Workbook workbook = Workbook.getWorkbook(new File(path));
			Sheet sheet = workbook.getSheet(0);// 获取到第一个表格
			Statement stmt = dbConn.createStatement();
			for (int i = 1; i < sheet.getRows()&&sheet.getCell(1, i).getContents()!=""; i++) {
				String id = sheet.getCell(0, i).getContents();
				if(id.length()<9&&id!="") id="0"+id;
				String name = sheet.getCell(1, i).getContents();
				String classNo = sheet.getCell(2, i).getContents();
				String entrance="";
				if(id!="")	entrance = "20" + id.substring(2, 4);
				String gender = sheet.getCell(3, i).getContents();
				String sql = "insert into studentList(stuId,stuName,entranceDate,classNo,stuGender) values('" + id + "','" + name+ "','" + entrance + "','"+classNo+"','"+gender+"')";
				stmt.execute(sql);
				System.out.println(id + "   " + entrance + "   " + name);
			}
			stmt.close();
			workbook.close();
		}
		dbConn.close();
	}
}
