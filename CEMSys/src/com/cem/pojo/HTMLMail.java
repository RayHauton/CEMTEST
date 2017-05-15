package com.cem.pojo;

import java.util.Map;

public class HTMLMail {
	private String subject;
	private String content;
	private String[] toList;
	private Map<String, String> pictures;
	private Map<String, String> attachments;

	public HTMLMail(String subject, String content, String[] toList, Map<String, String> pictures,
			Map<String, String> attachments) {
		super();
		this.subject = subject;
		this.content = content;
		this.toList = toList;
		this.pictures = pictures;
		this.attachments = attachments;
	}

	public HTMLMail() {

	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String[] getToList() {
		return toList;
	}

	public void setToList(String[] toList) {
		this.toList = toList;
	}

	public Map<String, String> getPictures() {
		return pictures;
	}

	public void setPictures(Map<String, String> pictures) {
		this.pictures = pictures;
	}

	public Map<String, String> getAttachments() {
		return attachments;
	}

	public void setAttachments(Map<String, String> attachments) {
		this.attachments = attachments;
	}

}
