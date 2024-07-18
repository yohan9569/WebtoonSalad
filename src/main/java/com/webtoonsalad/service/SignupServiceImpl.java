package com.webtoonsalad.service;

import org.apache.ibatis.annotations.Param;
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
        // 비밀번호 암호화
        String encodedPassword = passwordEncoder.encode(password);
        
        // 사용자 등록 및 권한 부여
        signupMapper.signup(id, encodedPassword, name);
        signupMapper.insertAuthority(id, "ROLE_MEMBER"); // 기본 권한 설정
    }
    
    @Override
    public boolean idChk(String id) {
    	return signupMapper.idChk(id);
    };
    
    @Override
    public boolean nameChk(String name) {
    	return signupMapper.nameChk(name);
    };
	
}