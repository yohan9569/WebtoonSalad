package com.webtoonsalad.service;

import org.apache.ibatis.annotations.Param;

import com.webtoonsalad.dto.UserDTO;

public interface SignupService {

	void signup(@Param("id") String id, @Param("pw") String pw, @Param("name") String name ) throws Exception;

	boolean idChk(@Param("id") String id);
	
	boolean nameChk(@Param("name") String name);
	
    UserDTO getUserById(String id) throws Exception;
    
    void updatePassword(String id, String newPassword) throws Exception;
}
