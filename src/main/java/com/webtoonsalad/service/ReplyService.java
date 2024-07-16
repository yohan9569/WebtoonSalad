package com.webtoonsalad.service;

import java.util.List;

import com.webtoonsalad.dto.ReplyDTO;

public interface ReplyService {

	public void register(ReplyDTO dto) throws Exception;
	public List<ReplyDTO> getList(Long tbl_wagle_id) throws Exception;
	public boolean remove(Long id) throws Exception;
}
