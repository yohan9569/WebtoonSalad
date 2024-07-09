package com.webtoonsalad.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WebtoonMapper {
    
    void updateLastup(String id);
}
