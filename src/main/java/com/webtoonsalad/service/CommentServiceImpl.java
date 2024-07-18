package com.webtoonsalad.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webtoonsalad.dto.CommentDTO;
import com.webtoonsalad.dto.WebtoonDTO;
import com.webtoonsalad.mapper.CommentMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CommentServiceImpl implements CommentService{

	
	@Autowired
	private CommentMapper commentMapper;
	
	@Override
    public void writeComment(String content, String userId, String webtoonId) throws Exception {
        commentMapper.writeComment(content, userId, webtoonId);
    }

    @Override
    public void deleteComment(String userId, String webtoonId) throws Exception {
        commentMapper.deleteComment(userId, webtoonId);
    }

    @Override
    public void editComment(String content, String userId, String webtoonId) throws Exception {
        commentMapper.editComment(content, userId, webtoonId);
    }

    @Override
    public List<CommentDTO> getCommentList(String userId, String webtoonId) throws Exception {
    	if (userId == null) {
    		System.out.println("userId is null");
        } else if (userId.isEmpty()) {
        	System.out.println("userId is empty");
        } else {
    	System.out.println("Fetching comments for userId: "+ userId+ " and webtoonId: "+ webtoonId);
        }
        List<CommentDTO> comments = commentMapper.getCommentList(userId, webtoonId);
        System.out.println("Fetched comments: "+ comments);
        return comments;
    }

    @Override
    public CommentDTO getMyComment(String userId, String webtoonId) throws Exception {
    	 System.out.println("getMyComment 호출됨 - userId: " + userId + ", webtoonId: " + webtoonId);
         CommentDTO comment = commentMapper.getMyComment(userId, webtoonId);
         System.out.println("DB 조회 결과 - comment: " + comment);
         return comment;
//        return commentMapper.getMyComment(userId, webtoonId);
    }
}

