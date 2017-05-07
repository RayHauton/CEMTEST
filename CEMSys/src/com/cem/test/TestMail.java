package com.cem.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cem.util.BeanUtil;
import com.cem.util.MailUtil;

public class TestMail {
	public void testMail() throws Exception{
		((MailUtil) BeanUtil.getBean(MailUtil.class)).sendMail(new String[]{"2433983339@qq.com"}, "subject", "textContent", null);
	}

	
	public void testMaio() {
		int j = 1;
		Map<String, String> map = new HashMap<>();
		String[] temp = s3.split("src=\"");//temp的长度-1为图片的个数
		List<String> list = new ArrayList<>();
		for (int i = 0; i < temp.length; i++) {
			if (temp[i].contains("\" title")) {
				String s1 = temp[i].split("\" title")[0];
				list.add(s1);
				map.put("c"+j, s1);
				s3 = s3.replace(s1, "cid:c"+j);
				++j;
			}
		}
		System.out.println(s3);
	}
	
	private String s3;
	
	public void sjflkd(){
		s3 = "<p><img src=\"http://localhost:8080/CEMSys/ueditor/jsp/upload/image/20170412/1491987099916003638.jpg\" title=\"1491987099916003638.jpg\" alt=\"3babc5c8a786c91753cca0c3ce3d70cf39c757da.jpg\"/></p><p><img src=\"http://localhost:8080/CEMSys/ueditor/jsp/upload/image/20170412/1491987100014070581.jpg\" title=\"1491987100014070581.jpg\"/></p><p><img src=\"http://localhost:8080/CEMSys/ueditor/jsp/upload/image/20170412/1491987100069085031.jpg\" title=\"1491987100069085031.jpg\"/></p><p><img src=\"http://localhost:8080/CEMSys/ueditor/jsp/upload/image/20170412/1491987100113057413.jpg\" title=\"1491987100113057413.jpg\"/>这是一个神奇的妹子</p><p><br/></p>";
		testMaio();
		System.out.println(s3);
	}
}
