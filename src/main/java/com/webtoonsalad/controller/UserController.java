package com.webtoonsalad.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/user/*")
@Controller
public class UserController {
   
    @GetMapping("/all")
    public void doAll() {      
        System.out.println("do all can access everybody");        
    }//end doall
   
    @GetMapping("/member")
    public void doMember() {        
        System.out.println("logined member");    
    }//end doMember
  
}//end class
