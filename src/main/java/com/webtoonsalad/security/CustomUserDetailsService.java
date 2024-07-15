package com.webtoonsalad.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.webtoonsalad.domain.MemberVO;
import com.webtoonsalad.mapper.MemberMapper;
import com.webtoonsalad.security.domain.CustomUser;

import lombok.extern.log4j.Log4j;

@Log4j
public class CustomUserDetailsService implements UserDetailsService {
   
    @Autowired
    private MemberMapper membermapper;
   
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       
        log.warn("Load User By UserName :" +username);
       
        MemberVO vo = membermapper.read(username);      
        log.warn("Query by memebr maper :" +vo);
           
        //삼항식
        return ( vo == null
                ? null
                : new CustomUser(vo) );
    }//end loadUserByUsern...
   
   

}//end class
