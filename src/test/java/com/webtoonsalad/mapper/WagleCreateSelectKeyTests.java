package com.webtoonsalad.mapper;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.webtoonsalad.dto.WagleCreateDTO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class WagleCreateSelectKeyTests {

    @Autowired
    private WagleMapper wagleMapper;
    
    @Test
    @Transactional
    @Rollback(false)
    public void testCreateWagle() {
    	
    	// 현재 날짜와 시간을 Timestamp 형식으로 설정
//        Timestamp now = Timestamp.valueOf(LocalDateTime.now());

        WagleCreateDTO dto = new WagleCreateDTO();
        dto.setTitle("테스트 제목 SelectKey3");
//        dto.setCreate_date(now);  // 문자열로 설정
        dto.setView_cnt(100L);
        dto.setRec_cnt(100L);
        dto.setContent("테스트 글");
        dto.setContent_file(null);  // NULL 값으로 설정
        dto.setUser_id("test1");
        
        // Mapper 메서드 호출
        wagleMapper.insertSelectKeyWagle(dto);
    }
}
