package com.webtoonsalad.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.webtoonsalad.dto.ReplyDTO;

@Mapper
public interface ReplyMapper {

	public void insertSelectKeyReply(ReplyDTO dto) throws SQLException;
	public List<ReplyDTO> selectReplyList(Long tbl_wagle_id) throws SQLException;
	public int deleteReply(Long id) throws SQLException;
}
