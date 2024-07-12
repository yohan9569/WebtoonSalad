package com.webtoonsalad.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.webtoonsalad.dto.WebtoonDTO;

public interface WebtoonService {

	List<WebtoonDTO> getAllWebtoonList() throws Exception;
	List<WebtoonDTO> getDayWebtoonList(@Param("day") String day) throws Exception;
	WebtoonDTO getDetail(@Param("id") String id) throws Exception;
	Integer getJjimCount(@Param("id") String id) throws Exception;

}
