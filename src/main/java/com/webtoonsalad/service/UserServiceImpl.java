package com.webtoonsalad.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webtoonsalad.dto.UserDTO;
import com.webtoonsalad.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

	@Override
	public List<UserDTO> searchUsersByNickname(String keyword) {
		return userMapper.findUsersByNickname(keyword);
	}

}
