package com.webtoonsalad.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webtoonsalad.mapper.SignupMapper;

@Service
public class SignupServiceImpl implements SignupService {
	
	@Autowired
    private SignupMapper signupMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public void signup(String id, String password, String name) throws Exception {
        String encodedPassword = passwordEncoder.encode(password);
        signupMapper.signup(id, encodedPassword, name);
        signupMapper.insertAuthority(id, "ROLE_MEMBER");  // 기본 권한 설정
    }
	
}