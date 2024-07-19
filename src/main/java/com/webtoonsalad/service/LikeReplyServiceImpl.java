package com.webtoonsalad.service;

import com.webtoonsalad.dto.LikeReplyDTO;
import com.webtoonsalad.mapper.LikeReplyMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LikeReplyServiceImpl implements LikeReplyService {

    @Autowired
    private LikeReplyMapper likeReplyMapper;

    @Transactional
    @Override
    public boolean toggleLikeReply(LikeReplyDTO dto) throws Exception {
        int count = likeReplyMapper.isLiked(dto.getTbl_user_id(), dto.getTbl_reply_id());
        if (count > 0) {
            likeReplyMapper.deleteLike(dto);
            return false; // 추천 삭제됨
        } else {
            likeReplyMapper.addLike(dto);
            return true; // 추천 추가됨
        }
    }

    @Override
    public int getRecommendCount(Long replyId) {
        return likeReplyMapper.getRecommendCount(replyId);
    }
}
