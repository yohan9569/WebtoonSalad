package com.webtoonsalad.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.webtoonsalad.dto.WagleCreateDTO;
import com.webtoonsalad.dto.WagleDetailDTO;
import com.webtoonsalad.dto.WagleListDTO;

@Mapper
public interface WagleMapper {

	public List<WagleListDTO> selectWagleList();
	public void insertWagle(WagleCreateDTO dto);
	public void insertSelectKeyWagle(WagleCreateDTO dto);
	public WagleDetailDTO detailWagle(Long no);

}
