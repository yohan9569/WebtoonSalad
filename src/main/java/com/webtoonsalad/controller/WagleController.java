package com.webtoonsalad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.webtoonsalad.dto.WagleCreateDTO;
import com.webtoonsalad.service.WagleService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@AllArgsConstructor
@RequestMapping("/wagle/*")
public class WagleController {

	@Autowired
	private WagleService wagleService;
	
	@GetMapping("/list")
	public void list(Model model) {
		log.info("list");
		model.addAttribute("list", wagleService.getList());
	}
	
	@GetMapping("/register")
	public void register() {
		log.info("register");
	}
	
	
	@PostMapping("/register")
	public String register(WagleCreateDTO dto, RedirectAttributes rttr) {
		log.info("register" + dto);
		wagleService.register(dto);
		rttr.addFlashAttribute("result: " + dto.getId());
		return "redirect:/wagle/list";
	}
}
