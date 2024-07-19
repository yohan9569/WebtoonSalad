package com.webtoonsalad.controller;

import java.security.Principal;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.webtoonsalad.dto.UserDTO;
import com.webtoonsalad.service.SignupService;

@Controller
public class SignupController {

	private static final Logger logger = LoggerFactory.getLogger(SignupController.class);

	@Inject
	SignupService service;

	// 회원가입 페이지 요청 처리
	@GetMapping("/signup")
	public String getRegister(Model model) throws Exception {
		logger.info("get register");
		model.addAttribute("userDTO", new UserDTO());
		return "signup"; // 회원가입 폼으로 이동
	}

	// 회원가입 폼 제출 처리
	@PostMapping("/signup")
	public String postRegister(UserDTO userDTO, @RequestParam("id") String id, @RequestParam("name") String name,
			Model model) throws Exception {
		logger.info("post register");
		boolean result = service.idChk(id);
		boolean result2 = service.nameChk(name);
		try {
			if (!result && !result2) {
				// 사용자 등록 시도
				service.signup(userDTO.getId(), userDTO.getPw(), userDTO.getName());
				return "redirect:/customLogin"; // 성공 시 로그인 페이지로 리다이렉트
			} else {
				model.addAttribute("error", "이미 존재하는 아이디입니다.");
				return "signup";
			}

		} catch (Exception e) {
			// 실패 시 오류 메시지와 함께 다시 회원가입 폼으로 돌아감
			model.addAttribute("error", e.getMessage());
			return "signup";
		}

	}

	// 아이디 중복 체크
	@PostMapping("/checkId")
	@ResponseBody
	public String checkId(@RequestParam("id") String id) throws Exception {
		logger.info("checkId");
		boolean result = service.idChk(id);
		return result ? "false" : "true";
	}

	// 이름 중복 체크
	@PostMapping("/checkName")
	@ResponseBody
	public String checkName(@RequestParam("name") String name) throws Exception {
		logger.info("checkName");
		boolean result2 = service.nameChk(name);
		return result2 ? "false" : "true";
	}

    @PostMapping("/updatePassword")
    public String updatePassword(Principal principal,
                                 @RequestParam("newPassword") String newPassword,
                                 RedirectAttributes redirectAttributes) {
        try {
            String id = principal.getName();
            service.updatePassword(id, newPassword);
            redirectAttributes.addFlashAttribute("success", "비밀번호가 성공적으로 변경되었습니다.");
            return "redirect:/mypage?tab=info";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
            return "redirect:/mypage?tab=info";
        }
    }
}
