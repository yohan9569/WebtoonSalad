package com.webtoonsalad.dto;

import java.sql.Date;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class WagleCreateDTO {

	private String title;
	private Date create_date;
	private Long view_cnt;
	private Long rec_cnt;
	private String content;
	private String file;
	private String user_id;
	
}
