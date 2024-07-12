package com.webtoonsalad.service;

import java.util.List;

import com.webtoonsalad.dto.WagleCreateDTO;
import com.webtoonsalad.dto.WagleDetailDTO;
import com.webtoonsalad.dto.WagleListDTO;
import com.webtoonsalad.dto.WagleUpdateDTO;

public interface WagleService {

	public void register(WagleCreateDTO dto);
	public List<WagleListDTO> getList();
	public WagleDetailDTO getDetailWagle(Long id);
	public boolean modify(WagleUpdateDTO dto);
	public boolean remove(Long id);
	
}
