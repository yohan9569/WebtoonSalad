package com.webtoonsalad.service;

import com.webtoonsalad.integration.WebtoonApi;
import org.springframework.web.client.RestTemplate;

public class WebtoonServiceTest {

    public static void main(String[] args) throws Exception {
        // RestTemplate 인스턴스를 생성합니다.
        RestTemplate restTemplate = new RestTemplate();

        // WebtoonApi 인스턴스를 생성합니다.
        WebtoonApi webtoonApi = new WebtoonApi(restTemplate);

        // WebtoonService 인스턴스를 생성합니다.
        WebtoonService webtoonService = new WebtoonService(webtoonApi);

        // 데이터를 가져와서 출력합니다.
        webtoonService.fetchAndProcessWebtoons();
        
    }
}
