package org.example.ch09.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.example.ch09.dto.UserDTO;
import org.example.ch09.entity.User;
import org.example.ch09.security.MyUserDetails;
import org.example.ch09.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Log4j2
@RequiredArgsConstructor
@Controller
public class UserController {
    private final UserService userService;

    @GetMapping("/user/login")
    public String login() {
        return "/user/login";
    }

    @GetMapping("/user/register")
    public String register() {
        return "/user/register";
    }

    @PostMapping("/user/register")
    public String register(UserDTO dto) {
        UserDTO saveUser = userService.register(dto);

        return "redirect:/user/login?register=success";
    }

    @GetMapping("/user/info")
    public String info(Model model) {
        // 시큐리티 사용자 인증 객체
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        log.info(authentication);

        MyUserDetails details = (MyUserDetails) authentication.getPrincipal();
        User user = details.getUser();

        model.addAttribute(user);

        return "/user/info";
    }


}
