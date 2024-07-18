package com.webtoonsalad.mapper;

import java.sql.SQLException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.webtoonsalad.dto.WagleDetailDTO;
import com.webtoonsalad.dto.WagleUpdateDTO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class WagleUpdateTests {

	@Autowired
	private WagleMapper wagleMapper;
	
	@Test
	public void test() throws SQLException {
		WagleDetailDTO dto = new WagleDetailDTO();
		dto.setId(2L);
		dto.setTitle("업데이트");
		dto.setContent("업데이트");
		dto.setContent_file(null);
		log.info("update count: " + wagleMapper.updateWagle(dto));
	}
}
