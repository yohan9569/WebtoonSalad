package com.webtoonsalad.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.webtoonsalad.dto.WebtoonDTO;

@Mapper
public interface WebtoonMapper {
	// 오늘 웹툰 업데이트
	void resetIsUpdated();
	void updateWebtoonInfo(String id);

	// 전체 웹툰 불러오기
	List<WebtoonDTO> getAllWebtoonList() throws SQLException;
	
	// 해당 요일 웹툰 불러오기
	List<WebtoonDTO> getDayWebtoonList(@Param("day") String day) throws SQLException;
	
	// 선택한 웹툰 상세보기
	WebtoonDTO getDetail(@Param("id") String id) throws SQLException;
	
	// 선택한 웹툰 찜 수 불러오기
	Integer getJjimCount(@Param("id") String id) throws SQLException;
	
	// 키워드로 제목과 작가이름 검색하기
	List<WebtoonDTO> searchWebtoon(@Param("keyword") String keyword) throws SQLException;
}
