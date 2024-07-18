package com.webtoonsalad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.webtoonsalad.dto.PageDTO;
import com.webtoonsalad.dto.ReplyCreateDTO;
import com.webtoonsalad.dto.ReplyCriteria;
import com.webtoonsalad.dto.WagleCreateDTO;
import com.webtoonsalad.dto.WagleCriteria;
import com.webtoonsalad.dto.WagleDetailDTO;
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
	public void list(WagleCriteria wagleCri, Model model) throws Exception {
		log.info("list" + wagleCri);
		model.addAttribute("list", wagleService.getList(wagleCri));
		
		int total = wagleService.getTotal(wagleCri);
		model.addAttribute("pageMaker", new PageDTO(wagleCri, total));
	}
	
	
	@GetMapping("register")
	public String register() {
		return "wagle/register";
	}
	
	@PostMapping("register")
	public String register(@ModelAttribute WagleCreateDTO dto, RedirectAttributes rttr, WagleCriteria cri) throws Exception {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String username = auth.getName();
	    
	    dto.setUser_id(username);
	    
		log.info("register: " + dto);
		
		wagleService.register(dto);
		rttr.addFlashAttribute("result", dto.getId());
		rttr.addAttribute("pageNum", cri.getPageNum());
	    rttr.addAttribute("amount", cri.getAmount());
	    
		return "redirect:list";
	}
	
	
	@GetMapping("detail")
	public void get(@RequestParam("id") Long id, ReplyCriteria replyCri, Model model) throws Exception {
	    
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String username = auth.getName();
	    
		log.info("detail");
		
		model.addAttribute("loggedInUser", username);
		model.addAttribute("detailList", wagleService.getDetailWagle(id));
		model.addAttribute("replyList", replyService.getList(replyCri, id));
		
		int total = replyService.getTotal(replyCri, id);
		model.addAttribute("pageMaker", new PageDTO(replyCri, total));
	}
	
	@PostMapping("reply/register")
	public String registerReply(ReplyCreateDTO dto, RedirectAttributes rttr) throws Exception {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String username = auth.getName();
	    
	    dto.setUser_id(username);
	    
		log.info("registerReply: " + dto);
		
		replyService.register(dto);
		rttr.addFlashAttribute("result", "success");
		
		return "redirect:/wagle/detail?id=" + dto.getTbl_wagle_id();
	}
	
	@PostMapping("reply/remove")
	public String removeReply(@RequestParam("id") Long id, @RequestParam("tbl_wagle_id") Long tblWagleId, RedirectAttributes rttr) throws Exception {
	    log.info("removeReply: " + id);

	    if (replyService.remove(id)) {
	        rttr.addFlashAttribute("result", "success");
	    } else {
	        rttr.addFlashAttribute("result", "failure");
	    }

	    return "redirect:/wagle/detail?id=" + tblWagleId;
	}
	
	
	@GetMapping("modify")
	public String modify(@RequestParam("id") Long id, Model model) throws Exception {
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String username = auth.getName();
	    
	    WagleDetailDTO detail = wagleService.getDetailWagle(id);
	    model.addAttribute("loggedInUser", username);
	    model.addAttribute("detailList", detail);
	    
	    return "wagle/modify";
	}	
	
	@PostMapping("modify")
	public String modify(WagleDetailDTO dto, RedirectAttributes rttr) throws Exception {
		
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
