package com.webtoonsalad.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.webtoonsalad.integration.WebtoonApi;

@Service
public class WebtoonService {
    private final WebtoonApi webtoonApi;

    @Autowired
    public WebtoonService(WebtoonApi webtoonApi) {
        this.webtoonApi = webtoonApi;
    }

    //@Scheduled(cron = "0 0 0 * * ?") // 매일 자정에 실행
    public void fetchAndProcessWebtoons() throws Exception {
    	String[] providers = {"KAKAO", "NAVER"};
    	
    	
    	List<String> webtoonIds = new ArrayList<>();
    	for (String provider:providers) {
    		int page = 1;
        	boolean isLastPage = false;
        	
    		System.out.println(provider);
    		while (!isLastPage) {
    			String result = webtoonApi.getWebtoons(provider, page);
                // 데이터를 처리하는 로직 추가
                //System.out.println("Fetched webtoon data: " + result);
                
                // JSON 파싱
    			ObjectMapper objectMapper = new ObjectMapper();
    			JsonNode rootNode = objectMapper.readTree(result);
    			JsonNode webtoonsNode = rootNode.path("webtoons");

    			// id 값 추출 및 리스트에 추가
    			for (JsonNode webtoonNode : webtoonsNode) {
    				String id = webtoonNode.path("id").asText();
    				webtoonIds.add(id);
    				System.out.println(id);
    			}
    			
    			page++;
    			
    			if (rootNode.path("isLastPage").asText().equals("true"))
    				isLastPage = true;
    			
    			
    		}
    	}
    }
}
