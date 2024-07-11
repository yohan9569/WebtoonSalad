package com.webtoonsalad.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    String selectUserIdByNickname(@Param("nickname") String nickname);
}