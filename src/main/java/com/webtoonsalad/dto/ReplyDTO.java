package com.webtoonsalad.dto;

import java.sql.Date;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class ReplyDTO {

	private Long id;
	private String name;
	private String content;
	private Date create_date;
	private Long recommend_cnt;
	private Long tbl_wagle_id;
	private String tbl_user_id;
	
}
