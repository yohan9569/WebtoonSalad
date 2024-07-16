package com.webtoonsalad.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.webtoonsalad.dto.UserDTO;

@Mapper
public interface UserMapper {
    String selectUserIdByNickname(@Param("nickname") String nickname);
    public UserDTO read(String id);
}