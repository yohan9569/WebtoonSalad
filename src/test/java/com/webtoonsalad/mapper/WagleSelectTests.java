package com.webtoonsalad.mapper;

import java.sql.SQLException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.webtoonsalad.mapper.WagleMapper;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class WagleSelectTests {

	@Autowired
	private WagleMapper wagleMapper;
	
	@Test
	public void testSelectWagle() throws SQLException {
		wagleMapper.selectWagleList().forEach(wagle -> log.info(wagle));
	}
}
