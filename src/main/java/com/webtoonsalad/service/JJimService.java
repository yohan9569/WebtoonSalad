package com.webtoonsalad.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webtoonsalad.dto.WebtoonDTO;
import com.webtoonsalad.mapper.JJimMapper;
import com.webtoonsalad.mapper.UserMapper;

@Service
public class JJimService {
    private final JJimMapper jjimMapper;
    private final UserMapper userMapper;

    @Autowired
    public JJimService(JJimMapper jjimMapper, UserMapper userMapper) {
        this.jjimMapper = jjimMapper;
        this.userMapper = userMapper;
    }

    public List<WebtoonDTO> getJJimByUserId(String userId) {
        return jjimMapper.selectJJimByUserId(userId);
    }
    
    public String getUserIdByNickname(String nickname) {
        return userMapper.selectUserIdByNickname(nickname);
    }
    
    public boolean checkJjimExists(String userId, String webtoonId) {
    	return jjimMapper.checkJjimExists(userId, webtoonId);
    }
    
    public void insertJjim(String userId, String webtoonId) {
        jjimMapper.insertJjim(userId, webtoonId);
    }

    public void deleteJjim(String userId, String webtoonId) {
        jjimMapper.deleteJjim(userId, webtoonId);
    }
   
}
