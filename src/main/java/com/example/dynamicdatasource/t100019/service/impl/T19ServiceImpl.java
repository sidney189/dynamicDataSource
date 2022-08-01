package com.example.dynamicdatasource.t100019.service.impl;

import com.example.dynamicdatasource.t100019.dao.T19Dao;
import com.example.dynamicdatasource.t100019.service.T19Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class T19ServiceImpl implements T19Service {
    @Autowired
    private T19Dao t19Dao;

    @Override
    public Integer getCount() {
        return t19Dao.getCount();
    }
}
