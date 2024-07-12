package com.webtoonsalad.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.webtoonsalad.dto.WebtoonDTO;

public interface WebtoonService {

	List<WebtoonDTO> getAllWebtoonList() throws Exception;
	List<WebtoonDTO> getDayWebtoonList(@Param("day") String day) throws Exception;
	WebtoonDTO getDetail(@Param("id") String id) throws Exception;
	Integer getJJimCount(@Param("id") String id) throws Exception;

}
