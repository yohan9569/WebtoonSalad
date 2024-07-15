package com.webtoonsalad.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
public class SampleController {
    
    @GetMapping("/sample/member")
    public String memberPage(Authentication authentication, Model model) {
        log.info("Accessing member page");
        return "sample/member"; // 뷰 파일의 이름 (sample/member.jsp)
    }
}