package com.webtoonsalad.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webtoonsalad.dto.JJimDTO;
import com.webtoonsalad.mapper.JJimMapper;

@Service
public class JJimServiceImpl implements JJimService{
    private final JJimMapper jjimMapper;
    
    @Autowired
    public JJimServiceImpl(JJimMapper jjimMapper) {
        this.jjimMapper = jjimMapper;
    }
    
    @Override
    public List<JJimDTO> getJJimByUserId(String userId) {
        return jjimMapper.selectJJimByUserId(userId);
    }
    
    @Override
    public void updateLastView(String userId, String webtoonId) {
        jjimMapper.updateLastView(userId, webtoonId);
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
    public void deleteJJim(String userId, String webtoonId) {
        jjimMapper.deleteJJim(userId, webtoonId);
    }
   
}
