package com.webtoonsalad.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.webtoonsalad.dto.Criteria;
import com.webtoonsalad.dto.WagleListDTO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class WagleSelectWithPagingTests {

	@Autowired
	private WagleMapper wagleMapper;
	
	@Test
	public void test() throws Exception {
		Criteria cri = new Criteria();
		cri.setPageNum(1);
		cri.setAmount(10);
		List<WagleListDTO> list = wagleMapper.selectWagleListWithPaging(cri);
		
		list.forEach(wagle -> log.info(list));
	}
}
