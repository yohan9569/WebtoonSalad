package com.webtoonsalad.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.webtoonsalad.dto.UserDTO;
import com.webtoonsalad.mapper.UserMapper;
import com.webtoonsalad.security.domain.CustomUser;

import lombok.extern.log4j.Log4j;

@Log4j
public class CustomUserDetailsService implements UserDetailsService {
   
    @Autowired
    private UserMapper usermapper;
   
    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
       
        System.out.println("Load User By UserName :" +id);
       
        UserDTO vo = usermapper.read(id);      
        System.out.println("Query by memebr maper :" +vo);
           
        //삼항식
        return ( vo == null
                ? null
                : new CustomUser(vo) );
    }//end loadUserByUsern...
   
   

}//end class
