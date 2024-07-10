package com.webtoonsalad.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webtoonsalad.dto.WebtoonDTO;
import com.webtoonsalad.mapper.JJimMapper;

@Service
public class JJimService {
    private final JJimMapper jjimMapper;

    @Autowired
    public JJimService(JJimMapper jjimMapper) {
        this.jjimMapper = jjimMapper;
    }

    public List<WebtoonDTO> getJJimByUserId(String userId) {
        return jjimMapper.selectJJimByUserId(userId);
    }
}
