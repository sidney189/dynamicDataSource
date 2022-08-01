package com.example.dynamicdatasource.t100049.service.impl;

import com.example.dynamicdatasource.t100049.dao.T49Dao;
import com.example.dynamicdatasource.t100049.service.T49Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class T49ServiceImpl implements T49Service {
    @Autowired
    private T49Dao t49Dao;

    @Override
    public Integer getCount() {
        return t49Dao.getCount();
    }
}
