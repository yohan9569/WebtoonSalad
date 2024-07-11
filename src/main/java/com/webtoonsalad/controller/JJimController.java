package com.webtoonsalad.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.webtoonsalad.dto.WebtoonDTO;
import com.webtoonsalad.service.JJimService;

@Controller
public class JJimController {

    private final JJimService jjimService;

    @Autowired
    public JJimController(JJimService jjimService) {
        this.jjimService = jjimService;
    }

    @GetMapping("/jjim")
    public String getJJim(@RequestParam("userId") String userId, Model model) {
        List<WebtoonDTO> jjims = jjimService.getJJimByUserId(userId);
        model.addAttribute("jjims", jjims);
        return "jjim/jjim";
    }
    
    @GetMapping("/jjim/search")
    public String searchJJimByNickname(@RequestParam("nickname") String nickname, Model model) {
        String userId = jjimService.getUserIdByNickname(nickname);
        if (userId != null && !userId.isEmpty()) {
            return "redirect:/jjim?userId=" + userId;
        } else {
            model.addAttribute("error", "사용자를 찾을 수 없습니다.");
            return "jjim/jjim";
        }
    }
    
    @GetMapping("/jjim/toggleJjim")
    @ResponseBody
    public String toggleJjim(@RequestParam("webtoonId") String webtoonId) {
    	String userId = "test2"; // 로그인 시스템이 없으므로 user_id를 test1로 설정
    	try {
            if (jjimService.checkJjimExists(userId, webtoonId)) {
                jjimService.deleteJjim(userId, webtoonId);
            } else {
                jjimService.insertJjim(userId, webtoonId);
            }
            return "success";
        } catch (Exception e) {
            return "error: " + e.getMessage();
        }
    }
}