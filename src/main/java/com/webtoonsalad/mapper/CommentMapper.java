package com.webtoonsalad.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.webtoonsalad.dto.CommentDTO;
import com.webtoonsalad.dto.LikeCommentDTO;

@Mapper
public interface CommentMapper {

	// 한줄평 작성
	void writeComment(@Param("content") String content, @Param("userId") String userId, @Param("webtoonId") String webtoonId);

	// 한줄평 삭제
	void deleteComment(@Param("userId") String userId, @Param("webtoonId") String webtoonId);

	// 한줄평 수정
	void editComment(@Param("content") String content, @Param("userId") String userId, @Param("webtoonId") String webtoonId);

	// 한줄평 리스트 조회
	List<CommentDTO> getCommentList(@Param("userId") String userId, @Param("webtoonId") String webtoonId);

	// 특정 사용자의 한줄평 조회
	CommentDTO getMyComment(@Param("userId") String userId, @Param("webtoonId") String webtoonId);
	
}
