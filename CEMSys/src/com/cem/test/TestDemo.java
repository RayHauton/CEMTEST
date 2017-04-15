package com.cem.test;

import java.util.ArrayList;

public class TestDemo {
	public static void main(String[] args) throws Exception {
		ArrayList<String> list = new ArrayList<>();
		list.add("1");
		list.add("2");
		list.add("3");
//		list.remove("2");
		String s = "2";
		System.out.println(list.contains("2"));
		System.out.println(list.remove(list.indexOf(s)));
//		BufferedImage sourceImg = ImageIO.read(new FileInputStream(new File("C:\\Users\\RayHauton\\Desktop\\图标库\\all.png")));
//		System.out.println(sourceImg.getWidth());
//		System.out.println(sourceImg.getHeight());
	}
}
