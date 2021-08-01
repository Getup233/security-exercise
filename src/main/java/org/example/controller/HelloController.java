package org.example.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author morse
 * @create 2021-07-28
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping("/add")
    @PreAuthorize("hasAuthority('ADD') or hasAnyRole('ROLE_ROOT')")
    public String add(){
        return getUsersAuthorites();
    }

    @GetMapping("/edit")
    @PreAuthorize("hasAuthority('EDIT')")
    public String edit(){
        return getUsersAuthorites();
    }

    @GetMapping("/delete")
    @PreAuthorize("hasAuthority('DELETE')")
    public String delete(){
        return getUsersAuthorites();
    }

    public String getUsersAuthorites(){
        User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return principal.getUsername() + " can " + principal.getAuthorities();
    }
}
