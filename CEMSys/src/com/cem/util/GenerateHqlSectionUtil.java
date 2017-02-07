package com.cem.util;

import java.util.List;

/**
 * @author RayHauton
 * 这是一个形成hql查询语句中的某个部分的工具类
 *
 */
public class GenerateHqlSectionUtil {
	/**
	 * 因为数据库没有使用外键，所以涉及到一对多 或者多对多的查询，
	 * 不能使用hibernate的级联查询如果是一对多查询 只能先查出多的一端的所有ID
	 * 然后使用in进行查询；这样抽取形成hql语句中in的部分做一个工具类；
	 * @param manyPointIds多的一端的所有id
	 * @return 
	 */
	public String generateHql_IN(List<String> manyPointIds){
		StringBuffer in = new StringBuffer("(");
		for(String item:manyPointIds){
			in.append("'"+item+"'"+",");
		}
		return in.substring(0, in.length()-1)+")";
	}
}
