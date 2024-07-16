package com.webtoonsalad.mapper;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.webtoonsalad.dto.ReplyCriteria;
import com.webtoonsalad.dto.ReplyDTO;
import com.webtoonsalad.mapper.ReplyMapper;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReplyGetListWithPagingTests {

	@Autowired
	private ReplyMapper replyMapper;
	
	@Test
	public void test() throws SQLException {
		ReplyCriteria cri = new ReplyCriteria();
		cri.setPageNum(1);
		cri.setAmount(3);
		
		List<ReplyDTO> list = replyMapper.getListWithPaging(cri, 6L);
		list.forEach(reply -> log.info(reply));
	}
}
