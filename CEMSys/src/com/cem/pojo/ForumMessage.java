package com.cem.pojo;

import java.io.Serializable;
import java.util.Date;

public class ForumMessage implements Serializable{
	private int id;
	private int forumId;
	private String forumTitle;
	private int personId;
	private String personName;
	private java.util.Date time;
	private int objectReplyId;
	private String status;
	
	public ForumMessage(){
		
	}

	public ForumMessage(int id, int forumId, String forumTitle, int personId, String personName, Date time,
			int objectReplyId, String status) {
		super();
		this.id = id;
		this.forumId = forumId;
		this.forumTitle = forumTitle;
		this.personId = personId;
		this.personName = personName;
		this.time = time;
		this.objectReplyId = objectReplyId;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getForumId() {
		return forumId;
	}

	public void setForumId(int forumId) {
		this.forumId = forumId;
	}

	public String getForumTitle() {
		return forumTitle;
	}

	public void setForumTitle(String forumTitle) {
		this.forumTitle = forumTitle;
	}

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public java.util.Date getTime() {
		return time;
	}

	public void setTime(java.util.Date date) {
		this.time = date;
	}

	public int getObjectReplyId() {
		return objectReplyId;
	}

	public void setObjectReplyId(int objectReplyId) {
		this.objectReplyId = objectReplyId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
