package com.webtoonsalad.service;

import com.webtoonsalad.dto.LikeWagleDTO;

public interface LikeWagleService {
	
    public boolean toggleLikeWagle(LikeWagleDTO dto) throws Exception;
    public int getRecommendCount(Long wagleId) throws Exception;
    
}
