package com.webtoonsalad.security.domain;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.webtoonsalad.dto.UserDTO;

import lombok.Getter;

@Getter
public class CustomUser extends User{
   
    //Serialization
    private static final long serialVersionUID = 1L;
   
    private UserDTO member;
    
    public CustomUser(String id, String pw, Collection<? extends GrantedAuthority> authorities) {
        super(id, pw, authorities);
    }//end CustomUser...
   
    public CustomUser(UserDTO vo) {
       
        super(vo.getId()
             ,vo.getPw()
             ,vo.getAuthList()
              .stream()
              .map( auth -> new SimpleGrantedAuthority(auth.getAuthority()))
              .collect(Collectors.toList())            
        );//end super
       
        this.member = vo;
       
    }//end CustomUser

}//end class
