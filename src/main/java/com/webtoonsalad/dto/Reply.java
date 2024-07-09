package com.webtoonsalad.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class Reply {

	private Long id;
	private String content;
	private Date create_date;
	private Long like_cnt;
	private String user_id;
	private Long wagle_id;
	
}
