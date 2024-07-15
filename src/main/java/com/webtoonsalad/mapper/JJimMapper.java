package com.webtoonsalad.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.webtoonsalad.dto.JJimDTO;

@Mapper
public interface JJimMapper {
	// 사용자의 찜 목록 가져오기
	List<JJimDTO> selectJJimByUserId(@Param("userId") String userId);
	
	// lastview
	void updateLastView(@Param("userId") String userId, @Param("webtoonId") String webtoonId);
	
	// 사용자의 해당 웹툰 찜 수 확인하기
	boolean checkJJimExists(@Param("userId") String userId, @Param("webtoonId") String webtoonId);
	
	// 찜 추가
	void insertJJim(@Param("userId") String userId, @Param("webtoonId") String webtoonId);
    
	// 찜 삭제
	void deleteJJim(@Param("userId") String userId, @Param("webtoonId") String webtoonId);
}
