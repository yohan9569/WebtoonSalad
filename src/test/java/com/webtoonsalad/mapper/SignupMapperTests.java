package com.webtoonsalad.mapper;

import java.sql.SQLException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class SignupMapperTests {

	@Autowired
	private SignupMapper mapper;

	@Test
	public void testWriteComment() throws SQLException {
		String id = "member1111";
		String pw = "pw0";
		String name = "야야야야";

		log.info("id: " + id + ", pw: " + pw + ", name: " + name);
		mapper.signup(id, pw, name);
		log.info("한줄평 작성 성공");
	}
}
