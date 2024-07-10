package com.webtoonsalad.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
}