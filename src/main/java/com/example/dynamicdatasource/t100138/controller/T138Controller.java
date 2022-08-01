package com.example.dynamicdatasource.t100138.controller;

import com.example.dynamicdatasource.t100138.service.T138Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class T138Controller {

    @Autowired
    private T138Service t138Service;
    @Autowired


    @GetMapping("/test/138")
    public Integer getCount() {
        System.out.println("appKey");
        return t138Service.getCount();
    }

}
