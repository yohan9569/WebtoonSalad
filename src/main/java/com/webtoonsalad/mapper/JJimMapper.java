package com.webtoonsalad.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.webtoonsalad.dto.WebtoonDTO;

@Mapper
public interface JJimMapper {
	List<WebtoonDTO> selectJJimByUserId(@Param("id") String id);
}
