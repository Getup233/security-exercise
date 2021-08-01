package org.example.service;

import org.example.pojo.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author morse
 * @create 2021-07-28
 */
@Component
public class UserService implements UserDetailsService {

    private static Map<String , User> userMap;

    static {
        userMap = new HashMap<>();
//        userMap.put("银魂" , new User("银魂" , "yinshi"));
        userMap.put("银魂" , new User("银魂" , "$2a$10$3eAZqgywgEngbIS2rHOEYe/5ULGAt7j1Y0xc1rtVG1vvZ5L6BUupe"));
//        userMap.put("刺客五六七" , new User("刺客五六七" , "567"));
        userMap.put("刺客五六七" , new User("刺客五六七" , "$2a$10$Z5pn1/lMZAo2CGW4llEdueZrOywNjZ3zXhBQ3TSgh6tiu3GkZ6C/K"));
//        userMap.put("日常" , new User("日常" ,"youzi"));
        userMap.put("日常" , new User("日常" ,"$2a$10$//srucjvITkAC0OuGfE6FOkRuBA8e6BnlCaiWR31bkdq9anOrV/cu"));
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        User user = userMap.get(name);
        if(user == null){
            return null;
        }
//        密码使用明文
//        String password = "{noop}" + user.getPassword();
        String password = user.getPassword();
        List<GrantedAuthority> authorities = new ArrayList<>();
        if("银魂".equals(name)){
            authorities.add(new SimpleGrantedAuthority("ADD"));
        }else if("刺客五六七".equals(name)){
            authorities.add(new SimpleGrantedAuthority("EDIT"));
        }else if("日常".equals(name)){
            authorities.add(new SimpleGrantedAuthority("DELETE"));
        }
        return new org.springframework.security.core.userdetails.User(name , password , authorities);
    }
}
