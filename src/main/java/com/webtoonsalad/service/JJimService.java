package com.webtoonsalad.service;

import java.util.List;

import com.webtoonsalad.dto.JJimDTO;

public interface JJimService {

    public List<JJimDTO> getJJimByUserId(String userId);
    
    public String getUserIdByNickname(String nickname);
    
    public boolean checkJjimExists(String userId, String webtoonId);
    
    public void insertJjim(String userId, String webtoonId);

    public void deleteJjim(String userId, String webtoonId);
   
}
