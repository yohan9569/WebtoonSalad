package com.webtoonsalad.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webtoonsalad.dto.WebtoonDTO;
import com.webtoonsalad.mapper.WebtoonMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class WebtoonServiceImpl implements WebtoonService {

	@Autowired
	private WebtoonMapper mapper;

	@Override
	public List<WebtoonDTO> getAllWebtoonList() throws Exception {
		try {
			return mapper.getAllWebtoonList();
		} catch (Exception e) {
			log.info(e.getMessage());
			throw e;
		}
	}

	@Override
	public List<WebtoonDTO> getDayWebtoonList(String day) throws Exception {
		try {
			return mapper.getDayWebtoonList(day);
		} catch (Exception e) {
			log.info(e.getMessage());
			throw e;
		}
	}

	@Override
	public WebtoonDTO getDetail(String id) throws Exception {
		try {
			WebtoonDTO webtoon = mapper.getDetail(id);
			Integer jjimCount = mapper.getJjimCount(id);
			webtoon.setJjimCount(jjimCount != null ? jjimCount : 0);
			return webtoon;
		} catch (Exception e) {
			log.info(e.getMessage());
			throw e;
		}
	}

	@Override
	public Integer getJjimCount(String id) throws Exception {
		try {
			return mapper.getJjimCount(id);
		} catch (Exception e) {
			throw e;
		}
	}
}
