	package com.webtoonsalad.service;

import java.util.List;

import com.webtoonsalad.dto.Criteria;
import com.webtoonsalad.dto.WagleCreateDTO;
import com.webtoonsalad.dto.WagleDetailDTO;
import com.webtoonsalad.dto.WagleListDTO;
import com.webtoonsalad.dto.WagleUpdateDTO;

public interface WagleService {

	public void register(WagleCreateDTO dto) throws Exception;
	public List<WagleListDTO> getList() throws Exception;
	public List<WagleListDTO> getList(Criteria cri) throws Exception;
	public WagleDetailDTO getDetailWagle(Long id) throws Exception;
	public boolean modify(WagleUpdateDTO dto) throws Exception;
	public boolean remove(Long id) throws Exception;
	
}
