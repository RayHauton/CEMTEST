package com.cem.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.cem.util.GenerateHqlSectionUtil;

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
}
