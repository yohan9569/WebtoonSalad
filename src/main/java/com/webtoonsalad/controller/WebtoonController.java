package com.webtoonsalad.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.webtoonsalad.dto.WebtoonDTO;
import com.webtoonsalad.service.WebtoonService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class WebtoonController {
	@Autowired
	private WebtoonService webtoonService;

	@GetMapping("/home")
	public String list(Model model) throws Exception {
		try {
			List<WebtoonDTO> list = webtoonService.getAllWebtoonList();
			model.addAttribute("home", list);
			return "webtoon/home";
		} catch (Exception e) {
			throw e;
		} 
	}

}
