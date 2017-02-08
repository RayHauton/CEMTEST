package com.cem.test;

import com.cem.util.RegexUtil;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by RayHauton on 2017/1/29.
 */
public class PatternTest {
    @Test
    public void testEmailAndPhone() throws Exception{
        boolean flag=false;
        String email = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        String phone = "^(((13[0-9])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8})|(0\\d{2}-\\d{8})|(0\\d{3}-\\d{7})$";
        Pattern regexEmail = Pattern.compile(email);
        Pattern regexPhone = Pattern.compile(phone);
        @SuppressWarnings("unused")
		Matcher matcher = regexEmail.matcher("2433983339@qq.com");
        Matcher matcher1 = regexPhone.matcher("15651646589");
        flag = matcher1.matches();
        System.out.println(flag);
    }
    @Test
    public void testStudNumber() throws Exception{
        boolean flag=false;
        Pattern pattern  = Pattern.compile("^[0-9]{9,10}$");
        Matcher matcher = pattern.matcher("09001323");
        flag = matcher.matches();
        System.out.println(flag);
    }
    @Test
    public void testRegexUtil(){
        System.out.println(RegexUtil.getLoginMethod("15651646589@163.com"));

    }
}
