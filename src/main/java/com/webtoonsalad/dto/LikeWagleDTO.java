package com.webtoonsalad.dto;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class LikeWagleDTO {

	private String tbl_user_id;
	private Long tbl_wagle_id;
	
}
