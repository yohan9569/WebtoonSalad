package com.webtoonsalad.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.log4j.Log4j;

@Log4j
@Controller
public class CommonController {

	@GetMapping("/customLogout")
	public void logoutGET() {
		System.out.println("custom logout");
	}// end logout...

	@GetMapping("/customLogin")
	public void loginInput(String error, String logout, Model model) {
		System.out.println("error" + error);
		System.out.println("logout" + logout);

		if (error != null) {
			model.addAttribute("error", "Login Error check your Account");
		} // end if

		if (logout != null) {
			model.addAttribute("logout", "LoginOut!! ");
		} // end if

	}// end login..

	@GetMapping("/accessError")
	public void accessDenied(Authentication auth, Model model) {
		System.out.println("access Denied : " + auth);
		model.addAttribute("msg", "Access Denied");
	}
	
}
