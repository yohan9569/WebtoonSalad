package com.webtoonsalad.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.webtoonsalad.dto.UserDTO;
import com.webtoonsalad.service.UserService;

import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/user/*")
@Controller
public class UserController {
	
	private final UserService userService;
	
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }//end Constructor
   
    @GetMapping("/all")
    public void doAll() {      
        log.info("do all can access everybody");        
    }//end doall
   
    @GetMapping("/member")
    public void doMember() {        
        log.info("logined member");    
    }//end doMember
    
    @GetMapping("/search")
    @ResponseBody
    public List<UserDTO> searchUser(@RequestParam("keyword") String keyword) {
        return userService.searchUsersByNickname(keyword);
    }//end searchUser
    
}//end class
