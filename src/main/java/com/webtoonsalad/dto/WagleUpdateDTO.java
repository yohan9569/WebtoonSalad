package com.webtoonsalad.dto;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class WagleUpdateDTO {

	private Long id;
	private String title;
	private String content;
	
}
