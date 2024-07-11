package com.webtoonsalad.mapper;

import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class WebtoonDetailTests {
	
	@Autowired
    private WebtoonMapper mapper;
   
   
    @Test
    public void testGetDetail() throws SQLException {
    	assertNotNull(mapper);
        mapper.getDetail("kakao_3989");      
    }

}
