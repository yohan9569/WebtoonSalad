package com.webtoonsalad.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.webtoonsalad.dto.UserDTO;
import com.webtoonsalad.service.SignupService;

@Controller
//@RequestMapping("/webtoonsalad")
public class SignupController {

	private static final Logger logger = LoggerFactory.getLogger(SignupController.class);

	@Inject
	SignupService service;

	// 회원가입 get
	@GetMapping("/signup")
	public String getRegister(Model model) throws Exception {
		logger.info("get register");
		model.addAttribute("userDTO", new UserDTO());
		return "signup";
	}

	// 회원가입 post
	@PostMapping("/signup")
	public String postRegister(UserDTO userDTO, HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		logger.info("post register");
		service.signup(userDTO.getId(), userDTO.getPw(), userDTO.getName());
		return "redirect:/customLogin";
	}
}
