package com.webtoonsalad.service;

import java.util.List;
import java.util.Map;

public interface ReportService {
    List<Map<String, Object>> getPlatformRatio(String userId);
    List<Map<String, Object>> getWeekdayRatio(String userId);
    Map<String, Object> getUserJjimCountRank(String userId);
}