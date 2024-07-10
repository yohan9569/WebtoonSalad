package com.webtoonsalad.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webtoonsalad.dto.WebtoonDTO;
import com.webtoonsalad.mapper.WebtoonMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class WebtoonServiceImpl implements WebtoonService {
	
    @Autowired
    private WebtoonMapper mapper;
     
    @Override
    public List<WebtoonDTO> getAllWebtoonList() throws Exception {
        try {
            //디비에서 리스트 반환 작업
            return mapper.getAllWebtoonList();
        } catch (Exception e) {
            log.info(e.getMessage());
            throw e;
        }
    }


}
