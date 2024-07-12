package com.webtoonsalad.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.webtoonsalad.dto.JJimDTO;

@Mapper
public interface JJimMapper {
	List<JJimDTO> selectJJimByUserId(@Param("userId") String userId);
	
	// 사용자의 해당 웹툰 찜 수 확인하기
	boolean checkJjimExists(@Param("userId") String userId, @Param("webtoonId") String webtoonId);
	
	// 찜 추가
	void insertJjim(@Param("userId") String userId, @Param("webtoonId") String webtoonId);
    
	// 찜 삭제
	void deleteJjim(@Param("userId") String userId, @Param("webtoonId") String webtoonId);
}
