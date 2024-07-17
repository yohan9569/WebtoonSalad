package com.webtoonsalad.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webtoonsalad.dto.ReplyCreateDTO;
import com.webtoonsalad.dto.ReplyCriteria;
import com.webtoonsalad.dto.ReplyDTO;
import com.webtoonsalad.mapper.ReplyMapper;

import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class ReplyServiceImpl implements ReplyService{

	@Autowired
	private ReplyMapper replyMapper;
	
	@Override
	public int getTotal(ReplyCriteria cri, Long id) {
		log.info("get total" + cri);
		return replyMapper.getTotalCount(cri, id);
	}

	@Override
	public void register(ReplyCreateDTO dto) throws Exception {
		log.info("register" + dto);
		replyMapper.insertSelectKeyReply(dto);
	}

	@Override
	public List<ReplyDTO> getList(Long tbl_wagle_id) throws Exception {
		log.info("getList");
		return replyMapper.selectReplyList(tbl_wagle_id);
	}

	@Override
	public boolean remove(Long id) throws Exception {
		log.info("remove" + id);
		return replyMapper.deleteReply(id) == 1;
	}

	@Override
	public List<ReplyDTO> getList(ReplyCriteria cri, Long tbl_wagle_id) throws Exception {
		log.info("getList" + cri + ", " + tbl_wagle_id);
		return replyMapper.getListWithPaging(cri, tbl_wagle_id);
	}
}
