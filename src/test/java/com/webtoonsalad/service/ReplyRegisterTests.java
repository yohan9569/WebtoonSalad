package com.webtoonsalad.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.webtoonsalad.dto.ReplyCreateDTO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReplyRegisterTests {

	@Autowired
	private ReplyService replyService;
	
	@Test
	public void test() throws Exception{
		ReplyCreateDTO dto = new ReplyCreateDTO();
		for (int i=0; i<15; i++) {
			dto.setContent("댓글이다~" + i);
			dto.setTbl_wagle_id(29L);
			
			replyService.register(dto);
		}
//		dto.setContent("댓글이다~");
//		dto.setTbl_wagle_id(29L);
//		
//		replyService.register(dto);
	}
}
