package com.webtoonsalad.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.webtoonsalad.dto.WagleCreateDTO;
import com.webtoonsalad.dto.WagleDetailDTO;
import com.webtoonsalad.dto.WagleListDTO;
import com.webtoonsalad.dto.WagleUpdateDTO;

@Mapper
public interface WagleMapper {

	public void insertWagle(WagleCreateDTO dto);
	public void insertSelectKeyWagle(WagleCreateDTO dto);
	public List<WagleListDTO> selectWagleList();
	public WagleDetailDTO detailWagle(Long id);
	public int updateWagle(WagleUpdateDTO dto);
	public int deleteWagle(Long id);
	
}
