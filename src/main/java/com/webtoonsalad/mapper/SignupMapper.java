package com.webtoonsalad.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SignupMapper {
	
	void signup(@Param("id") String id, @Param("pw") String pw, @Param("name") String name );
	void insertAuthority(@Param("tbl_user_id") String tbl_user_id, @Param("authority") String authority);
}
