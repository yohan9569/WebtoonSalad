package com.webtoonsalad.dto;

import java.sql.Timestamp;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class WagleCreateDTO {

	private Long id;
	private String title;
	private Timestamp create_date;
	private Long view_cnt;
	private Long rec_cnt;
	private String content;
	private String content_file;
	private String user_id;
	
}
