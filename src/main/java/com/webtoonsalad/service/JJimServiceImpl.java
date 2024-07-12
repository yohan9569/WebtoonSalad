package com.webtoonsalad.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public boolean checkJJimExists(String userId, String webtoonId) {
    	return jjimMapper.checkJJimExists(userId, webtoonId);
    }
    
    @Override
    public void insertJJim(String userId, String webtoonId) {
        jjimMapper.insertJJim(userId, webtoonId);
    }

    @Override
    @Transactional
    public void deleteJJim(String userId, String webtoonId) {
        jjimMapper.deleteJJim(userId, webtoonId);
    }
   
}
