package com.example.dynamicdatasource.t100019.controller;

import com.example.dynamicdatasource.t100019.service.T19Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class T19Controller {

    @Autowired
    private T19Service t19Service;

    @GetMapping("/test/19")
    public Integer getCount() {
        return t19Service.getCount();
    }

}
