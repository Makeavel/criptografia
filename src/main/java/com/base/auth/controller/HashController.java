package com.base.auth.controller;

import com.base.auth.service.HashService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hash")
public class HashController {

    @Autowired
    private HashService service;

    @GetMapping("/{object}")
    public String criaHash(@PathVariable String object) throws Exception {
        return service.createHash(object);
    }

    @GetMapping("/a")
    public String criaHashs() throws Exception {
        return "aoba";
    }
}
