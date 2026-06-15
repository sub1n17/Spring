package org.example.service;

import org.springframework.stereotype.Component;

@Component
public class ArticleService {
    public void register() {
        System.out.println("핵심기능 - register...");
    }
    public void getArticle(String ano) {
        if(ano.equals("13")) {
            System.out.println("핵심기능 - getArticle...13");
        }
    }
    public void getArticleAll() {
        System.out.println("핵심기능 - getArticleAll...");
    }
    public void modify() {
        System.out.println("핵심기능 - modify...");
    }
    public void delete() {
        System.out.println("핵심기능 - delete...");
    }
}
