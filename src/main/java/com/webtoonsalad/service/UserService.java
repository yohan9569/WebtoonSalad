package com.webtoonsalad.service;

import java.util.List;

import com.webtoonsalad.dto.UserDTO;

public interface UserService {
	List<UserDTO> searchUsersByNickname(String keyword);
}
