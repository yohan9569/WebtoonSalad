package com.webtoonsalad.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.webtoonsalad.dto.JJimDTO;
import com.webtoonsalad.service.JJimService;
import com.webtoonsalad.service.UserService;
import com.webtoonsalad.service.WebtoonServiceImpl;


@Controller
public class JJimController {

    private final JJimService jjimService;
    private final UserService userService;

    @Autowired
    public JJimController(JJimService jjimService, UserService userService) {
        this.jjimService = jjimService;
        this.userService = userService;
    }
    
    @Autowired
    private WebtoonServiceImpl webtoonService;

    @GetMapping("/jjim")
    public String getJJim(@RequestParam("userId") String userId, Model model) {
        List<JJimDTO> jjims = jjimService.getJJimByUserId(userId);
        String userName = userService.getUserNameById(userId);
        model.addAttribute("jjims", jjims);
        model.addAttribute("userId", userId);
        model.addAttribute("userName", userName);
        return "jjim/jjim";
    }
    
    @GetMapping("/jjim/delete")
    @ResponseBody
    public String deleteJJim(@RequestParam("userId") String userId, @RequestParam("webtoonId") String webtoonId) {
        System.out.println("deleteJJim 호출 성공");
    	jjimService.deleteJJim(userId, webtoonId);
        return "success";
    }
    
    @PostMapping("/jjim/updateLastView")
    @ResponseBody
    public String updateLastView(@RequestParam("userId") String userId, @RequestParam("webtoonId") String webtoonId) {
        jjimService.updateLastView(userId, webtoonId);
        return "success";
    }
    
    @GetMapping("/jjim/list")
    public String getJJimList(@RequestParam("userId") String userId, Model model) {
    	List<JJimDTO> jjims = jjimService.getJJimByUserId(userId);
        model.addAttribute("jjims", jjims);
        return "jjim/list";
    }
    
    
    @RequestMapping(value = "/jjim/toggleJjim", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> toggleJJim(@RequestParam("userId") String userId, @RequestParam("webtoonId") String webtoonId) {
        //String userId = "test2"; // 로그인 시스템이 없으므로 user_id를 test2로 설정
        Map<String, Object> response = new HashMap<>();
        try {
            boolean jjimExists;
            if (jjimService.checkJJimExists(userId, webtoonId)) {
                jjimService.deleteJJim(userId, webtoonId);
                jjimExists = false;
            } else {
                jjimService.insertJJim(userId, webtoonId);
                jjimExists = true;
            }
            
            Integer jjimCount = webtoonService.getJJimCount(webtoonId); // jjimCount를 가져오는 메서드
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