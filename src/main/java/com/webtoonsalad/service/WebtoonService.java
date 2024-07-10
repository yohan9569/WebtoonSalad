package com.webtoonsalad.service;

import java.util.List;
import com.webtoonsalad.dto.WebtoonDTO;

public interface WebtoonService {

	// 전체 웹툰 불러오기
	List<WebtoonDTO> getAllWebtoonList() throws Exception;

}
