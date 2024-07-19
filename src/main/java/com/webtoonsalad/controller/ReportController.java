package com.webtoonsalad.controller;

import java.security.Principal;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webtoonsalad.service.ReportService;

@RestController
@RequestMapping("/api/report")
public class ReportController {

    private ReportService reportService;
    
    @Autowired
    public ReportController (ReportService reportService) {
    	this.reportService = reportService;
    }

    @GetMapping("/platform-ratio")
    public List<Map<String, Object>> getPlatformRatio(Principal principal) {
        return reportService.getPlatformRatio(principal.getName());
    }

    @GetMapping("/weekday-ratio")
    public List<Map<String, Object>> getWeekdayRatio(Principal principal) {
        return reportService.getWeekdayRatio(principal.getName());
    }

    @GetMapping("/user-jjim-count-rank")
    public Map<String, Object> getUserJjimCountRank(Principal principal) {
        return reportService.getUserJjimCountRank(principal.getName());
    }

}
