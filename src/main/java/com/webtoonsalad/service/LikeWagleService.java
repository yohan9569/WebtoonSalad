package com.webtoonsalad.service;

import com.webtoonsalad.dto.LikeWagleDTO;

public interface LikeWagleService {
    boolean toggleLikeWagle(LikeWagleDTO dto) throws Exception;
    int getRecommendCount(Long wagleId) throws Exception;
}
