package org.example.ch05.controller;

import lombok.RequiredArgsConstructor;
import org.example.ch05.dto.User5DTO;
import org.example.ch05.service.User5Service;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class User5Controller {
    private final User5Service service;

    @GetMapping("/user5/list")
    public String list(Model model) {
        List<User5DTO> dtoList = service.findAll();
        model.addAttribute("dtoList", dtoList);
        return "/user5/list";
    }

    @GetMapping("/user5/register")
    public String register() {
        return "/user5/register";
    }
    @PostMapping("/user5/register")
    public String register(User5DTO dto) {
        service.register(dto);
        return "redirect:/user5/list?register=success";
    }

    @GetMapping("/user5/modify")
    public String modify(String seq, Model model) {
        User5DTO dto = service.findById(Integer.parseInt(seq));

        model.addAttribute(dto);

        return "/user5/modify";
    }
    @PostMapping("/user5/modify")
    public String modify(User5DTO dto) {
        service.modify(dto);
        return "redirect:/user5/list?modify=success";
    }

    @GetMapping("/user5/remove")
    public String remove(String seq) {
        service.remove(Integer.parseInt(seq));
        return "redirect:/user5/list?remove=success";
    }
}
