package com.webtoonsalad.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.webtoonsalad.dto.WebtoonDTO;

public interface WebtoonService {

	// 전체 웹툰 불러오기
	List<WebtoonDTO> getAllWebtoonList() throws Exception;
	List<WebtoonDTO> getDayWebtoonList(@Param("day") String day) throws Exception;

}
