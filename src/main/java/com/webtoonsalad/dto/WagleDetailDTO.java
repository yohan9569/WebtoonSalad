package com.webtoonsalad.dto;

import java.sql.Date;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class WagleDetailDTO {

	private Long id;
	private String title;
	private String name;
	private Date create_date;
	private Long recommend_cnt;
	private String content;
	private String content_file;
	
}
