package com.webtoonsalad.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.webtoonsalad.dto.ReplyCriteria;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReplyGetListWithPagingTests {

	@Autowired
	private ReplyService replyService;
	
	@Test
	public void test() throws Exception {
		replyService.getList(new ReplyCriteria(1, 3), 6L).forEach(reply -> log.info(reply));
	}
}
