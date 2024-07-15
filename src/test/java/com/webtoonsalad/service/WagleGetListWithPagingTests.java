package com.webtoonsalad.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.webtoonsalad.dto.Criteria;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class WagleGetListWithPagingTests {

	@Autowired
	private WagleService wagleService;
	
	@Test
	public void test() throws Exception {
		wagleService.getList(new Criteria(1, 10)).forEach(wagle -> log.info(wagle));
	}
}
