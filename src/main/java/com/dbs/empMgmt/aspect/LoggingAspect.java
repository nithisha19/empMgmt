package com.dbs.empMgmt.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
//@Aspect
public class LoggingAspect {

    @Before("within(com.dbs.emp_mgmt.*.*)")
    public void logBefore(JoinPoint joinPoint){
        System.out.println("Before executing the method :: ");
        Arrays.asList(joinPoint.getArgs()).forEach(System.out::println);
    }

    @After("within(com.dbs.emp_mgmt.*.*)")
    public void logAfter(){
        System.out.println("After executing the method :: ");

    }
}