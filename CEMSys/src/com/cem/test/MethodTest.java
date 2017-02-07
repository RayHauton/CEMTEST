package com.cem.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.cem.pojo.Major;
import com.cem.util.GenerateHqlSectionUtil;
import com.cem.util.JsonUtil;


/**
 * Created by RayHauton on 2017/1/29.
 */
public class MethodTest {
    @Test
    public void testString(){
        System.out.println("linhuadong".indexOf("lin"));
    }
    @Test
    public void testGenerateHqlSection() throws Exception{
    	List<String> s= new ArrayList<>();
    	s.add("linhd");
    	s.add("kobe");
    	System.out.println(new GenerateHqlSectionUtil().generateHql_IN(s));
    }
    @Test
    public void testJsonUtils(){
    	List<Major> majors = new ArrayList<>();
    	Major m1 = new Major();
    	m1.setMajorId("01");
    	m1.setMajorName("linhd");
    	Major m2 = new Major();
    	m2.setMajorId("02");
    	m2.setMajorName("linxw");
    	majors.add(m1);
    	majors.add(m2);
    	System.out.println(JsonUtil.generatorJsonForMajors(majors));
    }
}
