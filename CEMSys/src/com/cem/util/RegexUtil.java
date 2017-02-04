package com.cem.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by RayHauton on 2017/1/29.
 * 功能：判断用户登录的方式；电话，邮箱，学号，用户名
 */
public class RegexUtil {
    public static String email = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
    public static String phone = "^(((13[0-9])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8})|(0\\d{2}-\\d{8})|(0\\d{3}-\\d{7})$";
    public static String studNumber = "^[0-9]{9,10}$";
    static Pattern emailPattern = null;
    static Pattern phonePattern = null;
    static Pattern studNumberPattern = null;
    static {
        emailPattern = Pattern.compile(email);
        phonePattern = Pattern.compile(phone);
        studNumberPattern = Pattern.compile(studNumber);
    }
    public static String getLoginMethod(String loginMethod){
        Matcher phoneMatcher = phonePattern.matcher(loginMethod);
        Matcher emailMatcher = emailPattern.matcher(loginMethod);
        Matcher studNumberMatcher = studNumberPattern.matcher(loginMethod);
        if(phoneMatcher.matches()){
            //手机号登录方式
            return "phone";
        } else if (emailMatcher.matches()) {
            //邮箱登录
            return "email";
        } else if (studNumberMatcher.matches()) {
            //学号登录
            return "studNum";
        } else {
            //用户名登录
            return "username";
        }
    }
}
