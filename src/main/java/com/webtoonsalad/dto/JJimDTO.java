package com.webtoonsalad.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class JJimDTO {
    private Long id; // JJim ID
    private String userId;
    private String webtoonId;
    private Date lastView;
    
    // Webtoon 관련 필드
    private String title;
    private String provider;
    private String updateDays;
    private String url;
    private String thumbnail1;
    private String thumbnail2;
    private String authors;
    private int isAdult;
    private int isUpdated;
    private int freeWaitHour;
    private Date lastUp;
    private int jjimCount;
}

