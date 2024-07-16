package com.webtoonsalad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.webtoonsalad.mapper.UserMapper;

import lombok.extern.log4j.Log4j;

@Log4j
@Controller
public class CommonController {
	
	@Autowired
	private UserMapper mapper;

	@GetMapping("/customLogout")
	public void logoutGET() {
		System.out.println("custom logout");
	}// end logout...

	@GetMapping("/customLogin")
	public String loginInput(String error, String logout, Model model) {
		System.out.println("error" + error);
		System.out.println("logout" + logout);
		model.addAttribute("auth", mapper.read("manager0"));
		
		if (error != null) {
			model.addAttribute("error", "Login Error check your Account");
		} // end if

		if (logout != null) {
			return "redirect:/home";
		} // end if
		
		return "customLogin";

	}// end login..

	@GetMapping("/accessError")
	public void accessDenied(Authentication auth, Model model) {
		System.out.println("access Denied : " + auth);
		model.addAttribute("msg", "Access Denied");
	}
	
}
