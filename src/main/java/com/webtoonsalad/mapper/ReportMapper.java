package com.webtoonsalad.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

@Mapper
public interface ReportMapper {
    List<Map<String, Object>> getPlatformRatio(@Param("userId") String userId);
    List<Map<String, Object>> getWeekdayRatio(@Param("userId") String userId);
    List<Map<String, Object>> getUserJjimCountRank();
}
