package com.webtoonsalad.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class UserDTO {

	private String id;
	private String pw;
	private String name;
	private Date join_date;
	
}
