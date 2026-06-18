package org.example.ch04.controller;

import lombok.RequiredArgsConstructor;
import org.example.ch04.dto.User3DTO;
import org.example.ch04.service.User3Service;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class User3Controller {
    private final User3Service service;

    @GetMapping("/user3/list")
    public String list(Model model) {
        List<User3DTO> dtoList = service.findAll();
        model.addAttribute("dtoList", dtoList);
        return "/user3/list";
    }

    @GetMapping("/user3/register")
    public String register() {
        return "/user3/register";
    }
    @PostMapping("/user3/register")
    public String register(User3DTO dto) {
        service.register(dto);
        return "redirect:/user3/list?register=success";
    }

    @GetMapping("/user3/modify")
    public String modify(String userid, Model model) {
        User3DTO dto = service.findById(userid);

        model.addAttribute(dto);

        return "/user3/modify";
    }
    @PostMapping("/user3/modify")
    public String modify(User3DTO dto) {
        service.modify(dto);
        return "redirect:/user3/list?modify=success";
    }

    @GetMapping("/user3/remove")
    public String remove(String userid) {
        service.remove(userid);
        return "redirect:/user3/list?remove=success";
    }
}
