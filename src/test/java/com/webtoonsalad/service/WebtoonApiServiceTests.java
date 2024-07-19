package com.webtoonsalad.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class WebtoonApiServiceTests {

    @Autowired
    private WebtoonApiService webtoonapiService;

    @Test
    public void testFetchAndProcessWebtoons() throws Exception {
        // 웹툰 데이터를 가져와서 처리하는 서비스 메서드 호출
    	webtoonapiService.fetchAndProcessWebtoons();

        log.info("Service method fetchAndProcessWebtoons 메서드 호출해서 lastup 업데이트 완료");
    }
}
