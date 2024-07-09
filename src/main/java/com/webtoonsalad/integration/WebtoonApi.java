package com.webtoonsalad.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class WebtoonApi {
    private final RestTemplate restTemplate;

    @Autowired
    public WebtoonApi(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getWebtoons(String provider, int page) {
        String apiUrl = "https://korea-webtoon-api-cc7dda2f0d77.herokuapp.com/webtoons?perPage=100&isUpdated=true";
        
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(apiUrl)
                .queryParam("provider", provider)
                .queryParam("page", page);
        return restTemplate.getForObject(uriBuilder.toUriString(), String.class);
    }
}
