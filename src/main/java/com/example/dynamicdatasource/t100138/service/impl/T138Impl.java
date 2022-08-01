package com.example.dynamicdatasource.t100138.service.impl;

import com.example.dynamicdatasource.t100138.dao.T138Dao;
import com.example.dynamicdatasource.t100138.service.T138Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class T138Impl implements T138Service {
    @Autowired
    private T138Dao t138Dao;

    @Override
    public Integer getCount() {
        return t138Dao.getCount();
    }
}
