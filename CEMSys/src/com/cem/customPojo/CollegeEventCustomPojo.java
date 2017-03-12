package com.cem.customPojo;
/*
 * 管理员的前端界面和普通用户的学院事件的前端界面的照片显示不一样
 * 管理员的默认不显示照片，普通用户查看的直接显示照片
 * 所以照片的路径是不一样的，因而设计了该类，用来存储照片的路径
 */
public class CollegeEventCustomPojo {
	private String imgPath;

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
}
