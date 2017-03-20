package com.cem.test;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;

import javax.imageio.ImageIO;

public class TestDemo {
	public static void main(String[] args) throws Exception {
		BufferedImage sourceImg = ImageIO.read(new FileInputStream(new File("C:\\Users\\RayHauton\\Desktop\\图标库\\all.png")));
		System.out.println(sourceImg.getWidth());
		System.out.println(sourceImg.getHeight());
	}
}
