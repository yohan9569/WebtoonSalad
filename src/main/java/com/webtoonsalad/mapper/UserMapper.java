package com.webtoonsalad.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.webtoonsalad.dto.UserDTO;

@Mapper
public interface UserMapper {
    List<UserDTO> findUsersByNickname(String keyword);
    public UserDTO read(String id);
}