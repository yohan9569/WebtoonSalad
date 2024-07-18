package com.webtoonsalad.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webtoonsalad.dto.LikeWagleDTO;
import com.webtoonsalad.mapper.LikeWagleMapper;

@Service
public class LikeWagleServiceImpl implements LikeWagleService {
	
	@Autowired
	private LikeWagleMapper likeWagleMapper;

	@Transactional
    @Override
    public boolean toggleLikeWagle(LikeWagleDTO dto) throws SQLException {
        int count = likeWagleMapper.isLiked(dto.getTbl_user_id(), dto.getTbl_wagle_id());
        if (count > 0) {
            likeWagleMapper.deleteLike(dto);
            return false; // 추천 삭제됨
        } else {
            likeWagleMapper.addLike(dto);
            return true; // 추천 추가됨
        }
    }

}
