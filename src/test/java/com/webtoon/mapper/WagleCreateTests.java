package com.webtoon.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.webtoonsalad.dto.WagleCreateDTO;
import com.webtoonsalad.mapper.WagleMapper;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class WagleCreateTests {

	@Autowired
	private WagleMapper wagleMapper;
	
	@Test
	public void testCreateWagle() {
		WagleCreateDTO dto = new WagleCreateDTO();
		dto.setTitle("테스트 제목");
//		dto.setCreate_date("2024-07-10");
		dto.setView_cnt(100L);
		dto.setRec_cnt(100L);
		dto.setContent("테스트 글");
		dto.setFile(null);
		dto.setUser_id("test1");
	}
}
