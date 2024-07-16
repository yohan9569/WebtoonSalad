package com.webtoonsalad.mapper;

import java.sql.SQLException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.webtoonsalad.dto.ReplyCreateDTO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReplyCreateSelectKeyTests {

	@Autowired
	private ReplyMapper replyMapper;
	
	@Test
    @Transactional
    @Rollback(false)
	public void test() throws SQLException {
		
		ReplyCreateDTO dto = new ReplyCreateDTO();
		dto.setContent("test");
		dto.setWagle_id(7L);
		
		replyMapper.insertSelectKeyReply(dto);
		
	}
}
