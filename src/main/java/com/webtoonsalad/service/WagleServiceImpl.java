package com.webtoonsalad.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webtoonsalad.dto.WagleCriteria;
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
public class WagleServiceImpl implements WagleService {
	
	@Autowired
	private WagleMapper wagleMapper;

	@Override
	public void register(WagleCreateDTO dto) throws Exception{
		log.info("register" + dto);
		wagleMapper.insertSelectKeyWagle(dto);
	}

	@Override
	public List<WagleListDTO> getList() throws Exception{
		log.info("getList");
		return wagleMapper.selectWagleList();
	}
	
	@Override
	public List<WagleListDTO> getList(WagleCriteria cri) throws Exception {
		log.info("get List with criteria" + cri);
		return wagleMapper.selectWagleListWithPaging(cri);
	}
	
	@Override
	public int getTotal(WagleCriteria cri) throws Exception {
		log.info("get total");
		return wagleMapper.getTotalCount(cri);
	}

	@Override
	public WagleDetailDTO getDetailWagle(Long id) throws Exception{
		log.info("getDetailWagle" + id);
		return wagleMapper.detailWagle(id);
	}

	@Override
	public boolean modify(WagleUpdateDTO dto) throws Exception{
		log.info("modify" + dto);
		return wagleMapper.updateWagle(dto) == 1;
	}

	@Override
	public boolean remove(Long id) throws Exception{
		log.info("remove" + id);
		return wagleMapper.deleteWagle(id) == 1;
	}

}
