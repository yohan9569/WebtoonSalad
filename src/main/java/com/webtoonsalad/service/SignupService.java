package com.webtoonsalad.service;

import org.apache.ibatis.annotations.Param;

public interface SignupService {

	void signup(@Param("id") String id, @Param("pw") String pw, @Param("name") String name ) throws Exception;
	
}