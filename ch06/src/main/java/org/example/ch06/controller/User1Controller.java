package org.example.ch06.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.Server;
import org.example.ch06.dto.User1DTO;
import org.example.ch06.service.User1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Controller
public class User1Controller {

    // 서비스 주입, @RequiredArgsConstructor 선언
    private final User1Service service;

    @GetMapping("/user1/list")
    public String list(Model model){

        // 서비스 호출
        List<User1DTO> dtoList = service.getUserAll();

        // 모델 참조
        model.addAttribute("dtoList", dtoList);

        return "/user1/list";
    }

    @GetMapping("/user1/register")
    public String register(){
        return "/user1/register";
    }

    @PostMapping("/user1/register")
    public String register(User1DTO dto){
        log.info(dto.toString());
        // 서비스 호출
        service.register(dto);
        // 목록 이동
        return "redirect:/user1/list";
    }


    @GetMapping("/user1/modify")
    public String modify(String userid, Model model){
        log.info(userid);

       User1DTO dto = service.getUser(userid);

       model.addAttribute(dto); // 키 값을 생략하면 소문자로 시작하는 객체 타입이 이름이 됨


        return "/user1/modify";
    }

    @PostMapping("/user1/modify")
    public String modify(User1DTO dto) {
        log.info(dto.toString());

        // service 호출
        service.modify(dto);

        return "redirect:/user1/list?modify=success";
    }

    @GetMapping("/user1/remove")
    public String remove(String userid) {
        log.info(userid);
        service.remove(userid);
        return "redirect:/user1/list?remove=success";
    }
}