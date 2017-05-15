package com.cem.test;

import java.io.IOException;

import org.apache.commons.net.smtp.SMTPClient;
import org.apache.commons.net.smtp.SMTPReply;
import org.xbill.DNS.Lookup;
import org.xbill.DNS.Record;
import org.xbill.DNS.Type;

public class ValidMail {
	public boolean checkEmail(String email) {
		if (!email.matches("[\\w\\.\\-]+@([\\w\\-]+\\.)+[\\w\\-]+")) {
			return false;
		}
		String host = "";
		String hostName = email.split("@")[1];
		Record[] result = null;
		SMTPClient client = new SMTPClient();
		try {
			Lookup lookup = new Lookup(hostName, Type.MX);
			lookup.run();
			if (lookup.getResult() != Lookup.SUCCESSFUL) {
				return false;
			} else {
				result = lookup.getAnswers();
			}
			// 连接到邮箱服务器
			for (int i = 0; i < result.length; i++) {
				host = result[i].getAdditionalName().toString();
				client.connect(host);
				if (!SMTPReply.isPositiveCompletion(client.getReplyCode())) {
					client.disconnect();
					continue;
				} else {
					break;
				}
			}
			client.login("163.com");
			client.setSender("nuaadadan@163.com");
			client.addRecipient(email);
			if (250 == client.getReplyCode()) {
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try{
				client.disconnect();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		return false;
	}
	public static void main(String args[]){
		ValidMail validMail = new ValidMail();
		long time1 = System.currentTimeMillis();
		System.out.println(validMail.checkEmail("987612820@qq.com"));
		long time2 = System.currentTimeMillis();
		System.out.println(time2 - time1);
	}
}
