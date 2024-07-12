package com.webtoonsalad.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.webtoonsalad.dto.WebtoonDTO;
import com.webtoonsalad.service.JJimService;
import com.webtoonsalad.service.WebtoonServiceImpl;

@Controller
public class JJimController {

    private final JJimService jjimService;

    @Autowired
    public JJimController(JJimService jjimService) {
        this.jjimService = jjimService;
    }
    
    @Autowired
    private WebtoonServiceImpl webtoonService;

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
    
    @RequestMapping(value = "/jjim/toggleJjim", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> toggleJjim(@RequestParam("webtoonId") String webtoonId) {
        String userId = "test2"; // 로그인 시스템이 없으므로 user_id를 test2로 설정
        Map<String, Object> response = new HashMap<>();
        try {
            boolean jjimExists;
            if (jjimService.checkJjimExists(userId, webtoonId)) {
                jjimService.deleteJjim(userId, webtoonId);
                jjimExists = false;
            } else {
                jjimService.insertJjim(userId, webtoonId);
                jjimExists = true;
            }
            
            Integer jjimCount = webtoonService.getJjimCount(webtoonId); // jjimCount를 가져오는 메서드
            if (jjimCount == null) {
                jjimCount = 0;
            }
            
            response.put("jjimExists", jjimExists);
            response.put("jjimCount", jjimCount);
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            response.put("error", e.getMessage());
            return response;
        }
    }

}