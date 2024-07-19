package com.webtoonsalad.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webtoonsalad.mapper.ReportMapper;

@Service
public class ReportServiceImpl implements ReportService {

    private final ReportMapper reportMapper;
    
    @Autowired
    public ReportServiceImpl (ReportMapper reportMapper){
    	this.reportMapper = reportMapper;
    }

    @Override
    public List<Map<String, Object>> getPlatformRatio(String userId) {
        return reportMapper.getPlatformRatio(userId);
    }

    @Override
    public List<Map<String, Object>> getWeekdayRatio(String userId) {
        return reportMapper.getWeekdayRatio(userId);
    }

    @Override
    public Map<String, Object> getUserJjimCountRank(String userId) {
        List<Map<String, Object>> ranks = reportMapper.getUserJjimCountRank();

        if (ranks == null || ranks.isEmpty()) {
            throw new IllegalStateException("Ranks data is null or empty");
        }

        int totalUsers = ranks.size();
        Integer userRank = ranks.stream()
                            .filter(rank -> rank.get("TBL_USER_ID") != null && rank.get("TBL_USER_ID").equals(userId))
                            .map(rank -> (Number) rank.get("RANK"))
                            .map(Number::intValue)
                            .findFirst()
                            .orElse(null);

        if (userRank == null) {
            userRank = totalUsers;
        }

        Map<String, Object> result = new HashMap<>();
        result.put("totalUsers", totalUsers);
        result.put("userRank", userRank);
        return result;
    }
}
