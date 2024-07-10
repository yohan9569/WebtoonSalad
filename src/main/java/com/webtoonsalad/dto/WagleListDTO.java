package com.webtoonsalad.dto;

import java.sql.Date;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class WagleListDTO {

	private Long row_number;
	private String title;
	private String name;
	private Date create_date;
	private Long view_cnt;
	private Long recommend_cnt;
	
}
