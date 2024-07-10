package com.webtoonsalad.mapper;

import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.webtoonsalad.dto.WebtoonDTO;
import com.webtoonsalad.mapper.WebtoonMapper;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class WebtoonListTests {
	@Autowired
    private WebtoonMapper mapper;
   
   
    @Test
    public void testGetList() throws SQLException {
    	assertNotNull(mapper);
        log.info("----1번째 방법----");
       
        List<WebtoonDTO> list = mapper.getAllWebtoonList();    
        for (WebtoonDTO i : list) {
            log.info(i);
        }
       
        log.info("----2번째 방법----");
        mapper.getAllWebtoonList().forEach(board -> log.info(board));      
    }

}
