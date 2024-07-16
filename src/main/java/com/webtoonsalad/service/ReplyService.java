package com.webtoonsalad.service;

import java.util.List;

import com.webtoonsalad.dto.ReplyCreateDTO;
import com.webtoonsalad.dto.ReplyCriteria;
import com.webtoonsalad.dto.ReplyDTO;

public interface ReplyService {
	public List<ReplyDTO> getList(ReplyCriteria cri, Long tbl_wagle_id) throws Exception;
	
	public void register(ReplyCreateDTO dto) throws Exception;
	public List<ReplyDTO> getList(Long tbl_wagle_id) throws Exception;
	public boolean remove(Long id) throws Exception;
}
