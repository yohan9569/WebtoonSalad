package com.webtoonsalad.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.webtoonsalad.dto.WebtoonDTO;
import com.webtoonsalad.service.JJimService;
import com.webtoonsalad.service.WebtoonService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class WebtoonController {
	@Autowired
	private WebtoonService webtoonService;
	private JJimService jjimService;
	
	public WebtoonController(WebtoonService webtoonService, JJimService jjimService) {
        this.webtoonService = webtoonService;
        this.jjimService = jjimService;
    }

	@GetMapping("/home")
	public String list(@RequestParam(value = "day", required = false) String day, Model model) throws Exception {
		try {
			List<WebtoonDTO> webtoons; 
			if (day == null) {
                webtoons = webtoonService.getAllWebtoonList();
            } else {
                webtoons = webtoonService.getDayWebtoonList(day);
            }
			model.addAttribute("home", webtoons);
			return "webtoon/home";
		} catch (Exception e) {
			throw e;
		} 
	}
	
	@GetMapping("/webtoon/detail")
    public String getWebtoonDetail(@RequestParam("id") String id, Principal principal, Model model) throws Exception {
        try {
            WebtoonDTO webtoon = webtoonService.getDetail(id);
            String userId = (principal != null) ? principal.getName() : "guest"; // 로그인 여부 확인
            System.out.println("사용자 아이디~~~~~~~~~~~~~~"+ userId);
            boolean jjimExists = jjimService.checkJJimExists(userId, id);
            model.addAttribute("detail", webtoon);
            model.addAttribute("jjimExists", jjimExists);
            model.addAttribute("userId", userId);
            return "webtoon/detail";
        } catch (Exception e) {
            throw e;
        }
    }

	
	@PostMapping("/webtoon/updateLastView")
    @ResponseBody
    public String updateLastView(@RequestParam("userId") String userId, @RequestParam("webtoonId") String webtoonId) {
		jjimService.updateLastView(userId, webtoonId);
        return "success";
    }
	
	@RequestMapping(value = "/webtoon/search", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<WebtoonDTO>> searchWebtoon(
            @RequestParam String keyword) {
        try {
            List<WebtoonDTO> webtoons = webtoonService.searchWebtoon(keyword);
            return new ResponseEntity<>(webtoons, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
