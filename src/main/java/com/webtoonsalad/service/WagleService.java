package com.webtoonsalad.service;

import java.util.List;

import com.webtoonsalad.dto.WagleCreateDTO;
import com.webtoonsalad.dto.WagleListDTO;

public interface WagleService {

	public void register(WagleCreateDTO dto);
	
	public List<WagleListDTO> getList();
}
