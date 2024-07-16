package com.webtoonsalad.dto;

import java.sql.Date;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class ReplyCreateDTO {

	private	Long id;
	private String name;
	private String content;
	private Date create_date;
	private String user_id;
	private Long wagle_id;
	
}
