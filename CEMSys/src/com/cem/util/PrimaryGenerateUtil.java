package com.cem.util;
/**
 * 主键生成工具类
 * @author linhd
 *
 */
public class PrimaryGenerateUtil {
	/**
	 * 生成major表的逐渐
	 */
	public static String generateForMajorTable(String maxId){
		//获取数字部分
		String numStr = maxId.substring(1);
		//转成数字
		int tranToNum = Integer.parseInt(numStr)+1;
		//判断数字的位数
		return tranToNum<10?"M0"+tranToNum:"M"+tranToNum+"";
	}
	
	
	/**
	 * 生成学历的表的主键
	 */
	public static String generateForSchoolexperienceTable(String maxId){
		//获取数字部分
		String numStr = maxId.substring(2);
		//转成数字
		int tranToNum = Integer.parseInt(numStr)+1;
		//获得转化后的数字的位数
		int bitCount = (tranToNum+"").length();
		String newKey = tranToNum+"";
		for(int i=0;i<3-bitCount;i++){
			newKey="0"+newKey;
		}
		return "SE"+newKey;
	}
}
