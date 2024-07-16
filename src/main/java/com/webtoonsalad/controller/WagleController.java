package com.webtoonsalad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.webtoonsalad.dto.Criteria;
import com.webtoonsalad.dto.PageDTO;
import com.webtoonsalad.dto.WagleCreateDTO;
import com.webtoonsalad.dto.WagleUpdateDTO;
import com.webtoonsalad.service.ReplyService;
import com.webtoonsalad.service.WagleService;

import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@RequestMapping("/wagle/*")
public class WagleController {

	@Autowired
	private WagleService wagleService;
	
	@Autowired
	private ReplyService replyService;
	
	@GetMapping("list")
	public void list(Criteria cri, Model model) throws Exception {
		log.info("list" + cri);
		model.addAttribute("list", wagleService.getList(cri));
		model.addAttribute("pageMaker", new PageDTO(cri, 123));
	}
	
	
	@GetMapping("register")
	public String register() {
		return "wagle/register";
	}
	
	@PostMapping("register")
	public String register(@ModelAttribute WagleCreateDTO dto, RedirectAttributes rttr, Criteria cri) throws Exception {
		log.info("register: " + dto);
		
		wagleService.register(dto);
		rttr.addFlashAttribute("result", dto.getId());
		rttr.addAttribute("pageNum", cri.getPageNum());
	    rttr.addAttribute("amount", cri.getAmount());
		return "redirect:list";
	}
	
	
	@GetMapping("detail")
	public void get(@RequestParam("id") Long id, Model model) throws Exception {
		log.info("detail");
		model.addAttribute("detailList", wagleService.getDetailWagle(id));
		model.addAttribute("replyList", replyService.getList(id));
	}
	
	
	@GetMapping("modify")
	public String mofidy() {
		return "wagle/modify";
	}
	
	@PostMapping("modify")
	public String modify(WagleUpdateDTO dto, RedirectAttributes rttr) throws Exception {
		log.info("modify: " + dto);
		wagleService.modify(dto);
		rttr.addFlashAttribute("result", "success");
		return "redirect:list";
	}
	
	
	@PostMapping("remove")
	public String remove(@RequestParam("id") Long id, RedirectAttributes rttr) throws Exception {
		log.info("remove: " + id);
		if(wagleService.remove(id)) {
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:list";
	}
}
