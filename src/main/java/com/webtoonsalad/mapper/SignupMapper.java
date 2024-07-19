package com.webtoonsalad.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.webtoonsalad.dto.UserDTO;

@Mapper
public interface SignupMapper {
	
	void signup(@Param("id") String id, @Param("pw") String pw, @Param("name") String name );
	void insertAuthority(@Param("tbl_user_id") String tbl_user_id, @Param("authority") String authority);
	boolean idChk(@Param("id") String id);
	boolean nameChk(@Param("name") String name);
	UserDTO selectUserById(@Param("id") String id);
	void updatePassword(@Param("id") String id, @Param("newPassword") String newPassword) throws Exception;
}
