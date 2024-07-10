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
import com.webtoonsalad.mapper.JJimMapper;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class JJimMapperTest {
   @Autowired
    private JJimMapper jjimMapper;
   
   
    @Test
    public void testGetList() throws SQLException {
    	assertNotNull(jjimMapper);
       
        jjimMapper.selectJJimByUserId("test1").forEach(board -> log.info(board));      
    }

}
