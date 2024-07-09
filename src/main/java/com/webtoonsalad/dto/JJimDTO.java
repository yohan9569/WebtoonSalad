package com.webtoonsalad.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class JJimDTO {

	private Long id;
	private String user_id;
	private String webtoon_id;
	private Date lastView;
	
}
