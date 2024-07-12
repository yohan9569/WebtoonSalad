package com.webtoonsalad.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webtoonsalad.dto.JJimDTO;
import com.webtoonsalad.mapper.JJimMapper;
import com.webtoonsalad.mapper.UserMapper;

@Service
public class JJimServiceImpl implements JJimService{
    private final JJimMapper jjimMapper;
    private final UserMapper userMapper;

    @Autowired
    public JJimServiceImpl(JJimMapper jjimMapper, UserMapper userMapper) {
        this.jjimMapper = jjimMapper;
        this.userMapper = userMapper;
    }
    
    @Override
    public List<JJimDTO> getJJimByUserId(String userId) {
        return jjimMapper.selectJJimByUserId(userId);
    }
    
    @Override
    public String getUserIdByNickname(String nickname) {
        return userMapper.selectUserIdByNickname(nickname);
    }
    
    @Override
    public boolean checkJjimExists(String userId, String webtoonId) {
    	return jjimMapper.checkJjimExists(userId, webtoonId);
    }
    
    @Override
    public void insertJjim(String userId, String webtoonId) {
        jjimMapper.insertJjim(userId, webtoonId);
    }

    @Override
    public void deleteJjim(String userId, String webtoonId) {
        jjimMapper.deleteJjim(userId, webtoonId);
    }
   
}
