package org.example.advice;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

// 부가기능을 수행하는 Aspect 모듈 선언
@Aspect

@Component
public class MyAdvice {

    // 포인트컷 설정, 부가기능이 실행될 조건 설정, 내용이 없는 메서드
    @Pointcut("execution(void org.example.service.ArticleService.register())")
    public void insertPointCut() {}

    @Pointcut("execution(void org.example.service.ArticleService.get*(..))")
    public void selectPointCut(){}


    // 부가기능 메서드(어드바이스)
    @Before("insertPointCut() || selectPointCut()")
    public void before() {
        System.out.println("----------------------");
        System.out.println("부가기능 - before...");
    }

    @After("insertPointCut() || selectPointCut()")
    public void after() {
        System.out.println("부가기능 - after...");
        System.out.println("----------------------");
    }

    @AfterReturning("insertPointCut()")
    public void afterReturn() {
        System.out.println("부가기능 - afterReturn...");
    }

    @AfterThrowing("selectPointCut()")
    public void afterThrow() {
        System.out.println("----------------------");
        System.out.println("부가기능 - afterThrow...");
        System.out.println("----------------------");
    }




}
