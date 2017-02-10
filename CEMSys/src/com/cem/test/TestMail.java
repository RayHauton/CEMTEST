package com.cem.test;
import org.junit.*;

import com.cem.util.BeanUtil;
import com.cem.util.MailUtil;
public class TestMail {
	@Test
	public void testMail() throws Exception{
		((MailUtil) BeanUtil.getBean(MailUtil.class)).sendMail(new String[]{"2433983339@qq.com"}, "subject", "textContent", null);
	}
}
