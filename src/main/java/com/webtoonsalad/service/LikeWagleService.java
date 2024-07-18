package com.webtoonsalad.service;

import java.sql.SQLException;

import com.webtoonsalad.dto.LikeWagleDTO;

public interface LikeWagleService {

	public boolean toggleLikeWagle(LikeWagleDTO dto) throws SQLException;
	
}
