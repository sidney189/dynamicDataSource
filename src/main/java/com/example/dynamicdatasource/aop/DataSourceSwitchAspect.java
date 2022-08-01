package com.example.dynamicdatasource.aop;

import com.example.dynamicdatasource.config.DbContextHolder;
import com.example.dynamicdatasource.enums.DbTypeEnum;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class DataSourceSwitchAspect {

    @Pointcut("execution(* com.example.dynamicdatasource.t100019.dao..*.*(..))")
    private void t19Aspect() {
    }

    @Pointcut("execution(* com.example.dynamicdatasource.t100049.dao..*.*(..))")
    private void t49dbDictAspect() {
    }

    @Pointcut("execution(* com.example.dynamicdatasource.t100138.dao..*.*(..))")
    private void t138dbPartnerAspect() {
    }

    @Before("t19Aspect()")
    public void t19() {
        DbContextHolder.setDbType(DbTypeEnum.T100019);
    }

    @Before("t49dbDictAspect()")
    public void t49() {
        DbContextHolder.setDbType(DbTypeEnum.T100049);
    }

    @Before("t138dbPartnerAspect()")
    public void t138() {
        DbContextHolder.setDbType(DbTypeEnum.T100138);
    }
}