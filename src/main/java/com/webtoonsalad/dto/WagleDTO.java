package com.webtoonsalad.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class WagleDTO {

	private Long id;
	private String title;
	private Date create_date;
	private Long view_cnt;
	private Long rec_cnt;
	private String content;
	private String file;
	private String user_id;
	
}
