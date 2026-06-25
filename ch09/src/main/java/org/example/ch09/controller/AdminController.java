package org.example.ch09.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
    //  @PreAuthorize 인가 처리 활성화 설정 -> SecurityConfig 클래스 상단에 @EnableMethodSecurity 선언
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin/index")
    public String index() {

        return "/admin/index";
    }
}
