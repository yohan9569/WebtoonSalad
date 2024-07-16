package com.webtoonsalad.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.webtoonsalad.dto.ReplyCreateDTO;
import com.webtoonsalad.dto.ReplyCriteria;
import com.webtoonsalad.dto.ReplyDTO;

@Mapper
public interface ReplyMapper {
	
	public List<ReplyDTO> getListWithPaging(@Param("cri") ReplyCriteria cri, @Param("tbl_wagle_id") Long tbl_wagle_id) throws SQLException;
	public int getTotalCount(@Param("cri")ReplyCriteria cri, @Param("id") Long id);

	public void insertSelectKeyReply(ReplyCreateDTO dto) throws SQLException;
	public List<ReplyDTO> selectReplyList(@Param("tbl_wagle_id") Long tbl_wagle_id) throws SQLException;
	public int deleteReply(@Param("id") Long id) throws SQLException;
}
