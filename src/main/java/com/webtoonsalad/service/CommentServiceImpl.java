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
    	return commentMapper.getCommentList(userId, webtoonId);
    }

    @Override
    public CommentDTO getMyComment(String userId, String webtoonId) throws Exception {
        return commentMapper.getMyComment(userId, webtoonId);
    }
}

