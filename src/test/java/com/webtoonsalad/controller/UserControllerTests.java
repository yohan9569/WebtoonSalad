package com.webtoonsalad.controller;

import org.junit.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;


@Log4j
@RequestMapping("/sample/*")
@Controller
public class UserControllerTests {
	
	@Test
    @GetMapping("/all")
    public void doAll() {      
        log.info("do all can access everybody");        
    }//end doall
   
    @GetMapping("/member")
    public void doMember() {        
        log.info("logined member");    
    }//end doMember

}//end clas
