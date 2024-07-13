package com.webtoonsalad.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.webtoonsalad.dto.CommentDTO;

public interface CommentService {
	void writeComment(@Param("content") String content, @Param("userId") String userId,
			@Param("webtoonId") String webtoonId) throws Exception;

	void deleteComment(@Param("userId") String userId, @Param("webtoonId") String webtoonId) throws Exception;

	void editComment(@Param("content") String content, @Param("userId") String userId,
			@Param("webtoonId") String webtoonId) throws Exception;

	List<CommentDTO> getCommentList(@Param("userId") String userId, @Param("webtoonId") String webtoonId) throws Exception;

	CommentDTO getMyComment(@Param("userId") String userId, @Param("webtoonId") String webtoonId) throws Exception;

}
