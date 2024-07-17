package com.webtoonsalad.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.webtoonsalad.dto.CommentDTO;

@Mapper
public interface LikeCommentMapper {

	// 해당 한줄평 전체 좋아요 수 조회
	Integer getCLikeCount(@Param("commentId") int commentId);

	// 좋아요 추가
	void insertCLike(@Param("userId") String userId, @Param("commentId") int commentId);

	// 좋아요 삭제
	void deleteCLike(@Param("userId") String userId, @Param("commentId") int commentId);

	// 특정 사용자의 좋아요 여부
	boolean checkCLikeExists(@Param("userId") String userId, @Param("commentId") int commentId);

}
