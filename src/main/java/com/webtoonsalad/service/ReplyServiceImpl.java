package com.webtoonsalad.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webtoonsalad.dto.ReplyDTO;
import com.webtoonsalad.mapper.ReplyMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class ReplyServiceImpl implements ReplyService{

	@Autowired
	private ReplyMapper replyMapper;

	@Override
	public void register(ReplyDTO dto) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ReplyDTO> getList(Long tbl_wagle_id) throws Exception {
		log.info("getList");
		return replyMapper.selectReplyList(tbl_wagle_id);
	}

	@Override
	public boolean remove(Long id) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
