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
}
