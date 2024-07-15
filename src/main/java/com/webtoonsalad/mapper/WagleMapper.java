package com.webtoonsalad.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.webtoonsalad.dto.WagleCreateDTO;
import com.webtoonsalad.dto.WagleDetailDTO;
import com.webtoonsalad.dto.WagleListDTO;
import com.webtoonsalad.dto.WagleUpdateDTO;

@Mapper
public interface WagleMapper {

	public void insertWagle(WagleCreateDTO dto) throws SQLException;
	public void insertSelectKeyWagle(WagleCreateDTO dto) throws SQLException;
	public List<WagleListDTO> selectWagleList() throws SQLException;
	public WagleDetailDTO detailWagle(Long id) throws SQLException;
	public int updateWagle(WagleUpdateDTO dto) throws SQLException;
	public int deleteWagle(Long id) throws SQLException;
	
}
