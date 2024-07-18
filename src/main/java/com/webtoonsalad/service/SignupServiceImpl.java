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

		// ID가 "guest"인 경우 예외 발생
		if ("guest".equalsIgnoreCase(id)) {
			throw new Exception("사용할 수 없는 아이디입니다.");
		}

		// 비밀번호 암호화
		String encodedPassword = passwordEncoder.encode(password);

		// 사용자 등록 및 권한 부여
		signupMapper.signup(id, encodedPassword, name);
		signupMapper.insertAuthority(id, "ROLE_MEMBER"); // 기본 권한 설정
	}

	@Override
	public boolean idChk(String id) {
		// "guest" ID 체크
		if ("guest".equalsIgnoreCase(id)) {
			return true; // "guest"는 이미 사용 중인 것으로 간주
		}
		return signupMapper.idChk(id);
	};

	@Override
	public boolean nameChk(String name) {
		return signupMapper.nameChk(name);
	};

}