package org.example.ch04.controller;

import lombok.RequiredArgsConstructor;
import org.example.ch04.dto.User2DTO;
import org.example.ch04.service.User2Service;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class User2Controller {
    private final User2Service service;

    @GetMapping("/user2/list")
    public String list(Model model) {
        List<User2DTO> dtoList = service.findAll();
        model.addAttribute("dtoList", dtoList);
        return "/user2/list";
    }

    @GetMapping("/user2/register")
    public String register() {
        return "/user2/register";
    }
    @PostMapping("/user2/register")
    public String register(User2DTO dto) {
        service.register(dto);
        return "redirect:/user2/list?register=success";
    }

    @GetMapping("/user2/modify")
    public String modify(String userid, Model model) {
        User2DTO dto = service.findById(userid);

        model.addAttribute(dto);

        return "/user2/modify";
    }
    @PostMapping("/user2/modify")
    public String modify(User2DTO dto) {
        service.modify(dto);
        return "redirect:/user2/list?modify=success";
    }

    @GetMapping("/user2/remove")
    public String remove(String userid) {
        service.remove(userid);
        return "redirect:/user2/list?remove=success";
    }
}
