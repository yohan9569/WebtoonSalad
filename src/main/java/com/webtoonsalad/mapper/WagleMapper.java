package com.webtoonsalad.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.webtoonsalad.dto.WagleCreateDTO;
import com.webtoonsalad.dto.WagleCriteria;
import com.webtoonsalad.dto.WagleDetailDTO;
import com.webtoonsalad.dto.WagleListDTO;

@Mapper
public interface WagleMapper {

	public List<WagleListDTO> selectWagleListWithPaging(WagleCriteria cri) throws SQLException;
	public int getTotalCount(WagleCriteria cri) throws SQLException;
	
	public void insertWagle(WagleCreateDTO dto) throws SQLException;
	public void insertSelectKeyWagle(WagleCreateDTO dto) throws SQLException;
	public List<WagleListDTO> selectWagleList() throws SQLException;
	public WagleDetailDTO detailWagle(Long id) throws SQLException;
	public int updateWagle(WagleDetailDTO dto) throws SQLException;
	public int deleteWagle(Long id) throws SQLException;
	
	public void incrementViewCount(@Param("id") Long id) throws SQLException;
	
}
