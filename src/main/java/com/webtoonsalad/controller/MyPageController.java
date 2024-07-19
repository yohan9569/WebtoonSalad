package com.webtoonsalad.controller;

import java.security.Principal;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.webtoonsalad.service.ReportService;

@Controller
@RequestMapping("/mypage")
public class MyPageController {
	@Autowired
    private ReportService reportService;

    @GetMapping
    public String myPage(@RequestParam(defaultValue = "report") String tab, Model model, Principal principal) {
        if ("report".equals(tab)) {
            return myReport(principal, model);
        }
        
        String tabContent = "mypage/userinfo";
        model.addAttribute("tabContent", tabContent);
        return "mypage/mypage";
    }
    
    @GetMapping("/myreport")
    public String myReport(Principal principal, Model model) {
        String userId = principal.getName();
        Map<String, Object> rankData = reportService.getUserJjimCountRank(userId);

        int totalUsers = (int) rankData.get("totalUsers");
        int userRank = (int) rankData.get("userRank");
        double percentage = ((double) userRank / totalUsers) * 100;

        model.addAttribute("totalUsers", totalUsers);
        model.addAttribute("userRank", userRank);
        model.addAttribute("percentage", percentage);
        model.addAttribute("tabContent", "mypage/myreport");
        return "mypage/mypage";
    }
}
