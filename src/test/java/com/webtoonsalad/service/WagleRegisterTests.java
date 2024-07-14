package com.webtoonsalad.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.webtoonsalad.dto.WagleCreateDTO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class WagleRegisterTests {

	@Autowired
	private WagleService wagleService;

	@Test
	public void test() throws Exception{
		
		// 현재 날짜와 시간을 Timestamp 형식으로 설정
//      Timestamp now = Timestamp.valueOf(LocalDateTime.now());

		WagleCreateDTO dto = new WagleCreateDTO();
		dto.setTitle("테스트 제목 SelectKey4");
//      dto.setCreate_date(now);  // 문자열로 설정
		dto.setView_cnt(100L);
		dto.setRec_cnt(100L);
		dto.setContent("테스트 글");
		dto.setContent_file(null); // NULL 값으로 설정
		dto.setUser_id("test1");
		wagleService.register(dto);
		log.info("게시물 번호: " + dto.getId());
		
	}
}
