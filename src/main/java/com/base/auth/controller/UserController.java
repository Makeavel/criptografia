package com.base.auth.controller;

import com.base.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/route")
public class UserController {


    private UserService userService;

    @GetMapping("/{email}")
    public String param(@PathVariable String email){

        return userService.save(email);
    }
}
