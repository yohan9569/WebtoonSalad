package com.webtoonsalad.dto;

import java.util.Date;

public class SignupDTO {

	private String id;
	private String pw;
	private String name;
	private Date join_date;
	public String getUserId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getJoinDate() {
		return join_date;
	}
	public void setJoinDate(Date join_date) {
		this.join_date = join_date;
	}
	
	@Override
	public String toString() {
		return "SignupDTO [id=" + id + ", pw=" + pw + ", name=" + name + ", join_date="
				+ join_date + "]";
	}
	
}