package org.example.ch07.controller;

import lombok.RequiredArgsConstructor;
import org.example.ch07.dto.UserDTO;
import org.example.ch07.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class UserController {
    private  final UserService userService;

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
}
