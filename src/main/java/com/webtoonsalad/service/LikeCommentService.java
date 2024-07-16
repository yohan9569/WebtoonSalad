package com.webtoonsalad.service;

import org.apache.ibatis.annotations.Param;

public interface LikeCommentService {
	Integer getCLikeCount(@Param("commentId") int commentId) throws Exception;

	void insertCLike(@Param("userId") String userId, @Param("commentId") int commentId) throws Exception;

	void deleteCLike(@Param("userId") String userId, @Param("commentId") int commentId) throws Exception;

	boolean checkCLikeExists(@Param("userId") String userId, @Param("commentId") int commentId) throws Exception;


}
