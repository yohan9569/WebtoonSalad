package com.webtoonsalad.service;

import java.util.List;

import com.webtoonsalad.dto.JJimDTO;

public interface JJimService {

    public List<JJimDTO> getJJimByUserId(String userId);
    
    void updateLastView(String userId, String webtoonId);
    
    public boolean checkJJimExists(String userId, String webtoonId);
    
    public void insertJJim(String userId, String webtoonId);

    public void deleteJJim(String userId, String webtoonId);
   
}
