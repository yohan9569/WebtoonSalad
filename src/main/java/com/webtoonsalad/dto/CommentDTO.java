package com.webtoonsalad.dto;

import lombok.Data;

@Data
public class CommentDTO {

	private Long id;
	private String content;
	private Long like_cnt;
	private String user_id;
	private String webtoon_id;
	private UserDTO user;
	
}
