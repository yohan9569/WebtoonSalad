package com.webtoonsalad.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class WebtoonDTO {

	private String id;
	private String title;
	private String provider;
	private String updateDays;
	private String url;
	private String thumbnail1;
	private String thumbnail2;
	private String authors;
	private Long isAdult;
	private Long isUpdated;
	private Long freeWaitHour;
	private Date lastUp;
	private int jjimCount;
	
}
