package com.webtoonsalad.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webtoonsalad.dto.WagleCreateDTO;
import com.webtoonsalad.dto.WagleDetailDTO;
import com.webtoonsalad.dto.WagleListDTO;
import com.webtoonsalad.dto.WagleUpdateDTO;
import com.webtoonsalad.mapper.WagleMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class WagleServiceImple implements WagleService {
	
	@Autowired
	private WagleMapper wagleMapper;

	@Override
	public void register(WagleCreateDTO dto) {
		log.info("register" + dto);
		wagleMapper.insertSelectKeyWagle(dto);
	}

	@Override
	public List<WagleListDTO> getList() {
		log.info("getList");
		return wagleMapper.selectWagleList();
	}

	@Override
	public WagleDetailDTO getDetailWagle(Long id) {
		log.info("getDetailWagle" + id);
		return wagleMapper.detailWagle(id);
	}

	@Override
	public boolean modify(WagleUpdateDTO dto) {
		log.info("modify" + dto);
		return wagleMapper.updateWagle(dto) == 1;
	}

	@Override
	public boolean remove(Long id) {
		log.info("remove" + id);
		return wagleMapper.deleteWagle(id) == 1;
	}

}
