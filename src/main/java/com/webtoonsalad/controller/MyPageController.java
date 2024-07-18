package com.webtoonsalad.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyPageController {

    @GetMapping("/mypage")
    public String myPage(@RequestParam(defaultValue = "info") String tab, Model model) {
        String tabContent;
        switch (tab) {
            case "report":
                tabContent = "mypage/myreport";
                break;
            case "info":
            default:
                tabContent = "mypage/userinfo";
                break;
        }
        model.addAttribute("tabContent", tabContent);
        return "mypage/mypage";
    }
}
