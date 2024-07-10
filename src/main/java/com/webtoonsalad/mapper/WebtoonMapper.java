package com.webtoonsalad.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.webtoonsalad.dto.WebtoonDTO;

@Mapper
public interface WebtoonMapper {
	// 오늘 웹툰 업데이트
	void updateLastup(String id);

	// 전체 웹툰 불러오기
	List<WebtoonDTO> getAllWebtoonList() throws SQLException;
}
