package com.webtoonsalad.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.webtoonsalad.dto.WagleDetailDTO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class WagleUpdateTests {

	@Autowired
	private WagleService wagleService;
	
	@Test
	public void test() throws Exception {
		WagleDetailDTO dto = new WagleDetailDTO();
		dto.setId(3L);
		dto.setTitle("서비스 업데이트 테스트");
		dto.setContent("서비스 업데이트 테스트");
		dto.setContent_file(null);
		log.info(wagleService.modify(dto));
	}
}
