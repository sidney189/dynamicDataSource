package com.example.dynamicdatasource.t100049.controller;

import com.example.dynamicdatasource.t100049.service.T49Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class T49Controller {

    @Autowired
    private T49Service t49Service;
    @Autowired


    @GetMapping("/test/49")
    public Integer getCount() {
        System.out.println("appKey");
        return t49Service.getCount();
    }

}
