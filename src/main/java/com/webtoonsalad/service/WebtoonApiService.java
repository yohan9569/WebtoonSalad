package com.webtoonsalad.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.webtoonsalad.integration.WebtoonApi;
import com.webtoonsalad.mapper.WebtoonMapper;

@Service
public class WebtoonApiService {
	private final WebtoonApi webtoonApi;
	private final WebtoonMapper webtoonMapper;

	private static final String[] PROVIDERS = { "KAKAO", "NAVER" };

	@Autowired
	public WebtoonApiService(WebtoonApi webtoonApi, WebtoonMapper webtoonMapper) {
		this.webtoonApi = webtoonApi;
		this.webtoonMapper = webtoonMapper;
	}

	@Transactional
	// @Scheduled(cron = "0 0 0 * * ?") // 매일 자정에 실행
	public void fetchAndProcessWebtoons() throws Exception {
		List<String> webtoonIds = new ArrayList<>();
		ObjectMapper objectMapper = new ObjectMapper();

		for (String provider : PROVIDERS) {
			int page = 1;
			boolean isLastPage = false;

			while (!isLastPage) {
				String result = webtoonApi.getWebtoons(provider, page);

				// JSON 파싱
				JsonNode rootNode = objectMapper.readTree(result);
				JsonNode webtoonsNode = rootNode.path("webtoons");

				// id 값 추출 및 리스트에 추가
				for (JsonNode webtoonNode : webtoonsNode) {
					String id = webtoonNode.path("id").asText();
					webtoonIds.add(id);
				}

				page++;

				isLastPage = rootNode.path("isLastPage").asBoolean();
			}
		}
		
		webtoonMapper.resetIsUpdated();
		for (String id : webtoonIds) {
			webtoonMapper.updateWebtoonInfo(id);
		}
	}

}
