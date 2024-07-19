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
		dto.setContent("댓글이다~");
		dto.setTbl_wagle_id(1L);
		
		replyMapper.insertSelectKeyReply(dto);
		
	}
}
