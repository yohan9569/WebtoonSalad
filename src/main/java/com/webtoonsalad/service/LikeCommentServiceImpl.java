package com.webtoonsalad.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webtoonsalad.mapper.LikeCommentMapper;
@Service
public class LikeCommentServiceImpl implements LikeCommentService {
	
	@Autowired
	private LikeCommentMapper likecommentMapper;
	
	@Override
	public Integer getCLikeCount(int commentId) {
		return likecommentMapper.getCLikeCount(commentId);
	};

	@Override
	public void insertCLike(String userId, int commentId) {
		likecommentMapper.insertCLike(userId, commentId);
		
	}
	
	@Override
	public void deleteCLike(String userId, int commentId) {
		likecommentMapper.deleteCLike(userId, commentId);
	}
	
	@Override
	public boolean checkCLikeExists(String userId, int commentId) {
		return likecommentMapper.checkCLikeExists(userId, commentId);
	}
}
