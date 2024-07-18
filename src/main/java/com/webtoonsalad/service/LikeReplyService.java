package com.webtoonsalad.service;

import com.webtoonsalad.dto.LikeReplyDTO;

public interface LikeReplyService {
    public boolean toggleLikeReply(LikeReplyDTO dto) throws Exception;
    public int getRecommendCount(Long replyId) throws Exception;
}
