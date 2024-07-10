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
        List<WebtoonDTO> webtoons = jjimService.getJJimByUserId(userId);
        model.addAttribute("webtoons", webtoons);
        return "jjim";
    }
}