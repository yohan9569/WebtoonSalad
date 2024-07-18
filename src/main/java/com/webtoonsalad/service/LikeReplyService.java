package com.webtoonsalad.service;

import com.webtoonsalad.dto.LikeReplyDTO;

public interface LikeReplyService {
    boolean toggleLikeReply(LikeReplyDTO dto) throws Exception;
    int getRecommendCount(Long replyId) throws Exception;
}
