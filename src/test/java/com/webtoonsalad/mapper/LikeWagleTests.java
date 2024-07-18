package com.webtoonsalad.mapper;

import java.sql.SQLException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.webtoonsalad.dto.LikeWagleDTO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class LikeWagleTests {

	@Autowired
	private LikeWagleMapper likeWagleMapper;
	
	@Test
	@Transactional
    @Rollback(false)
	public void insertTest() throws SQLException {
		LikeWagleDTO dto = new LikeWagleDTO();
		dto.setTbl_user_id("test2");
		dto.setTbl_wagle_id(4L);
		
		likeWagleMapper.addLike(dto);
	}
}
