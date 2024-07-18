package com.webtoonsalad.mapper;

import java.sql.SQLException;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.webtoonsalad.dto.LikeWagleDTO;

@Mapper
public interface LikeWagleMapper {
	
	int isLiked(@Param("tbl_user_id") String tbl_user_id, @Param("tbl_wagle_id") Long tbl_wagle_id);
	public void addLike(LikeWagleDTO dto) throws SQLException;
	public void deleteLike(LikeWagleDTO dto) throws SQLException;
	
}
