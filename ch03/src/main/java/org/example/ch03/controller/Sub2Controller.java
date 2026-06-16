package org.example.ch03.controller;

import org.example.ch03.dto.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Sub2Controller {

    @GetMapping("/sub2/register")
    public String register() {
        return "/sub2/register";
    }

    @PostMapping("/sub2/register")
    public String register(UserDto userDto) {
        System.out.println(userDto);

        return "redirect:/index";
    }

    @GetMapping("/sub2/param")    // @RequestParam(파라미터명) : 파라미터 수신, 일반적으로 생략
    public String param(@RequestParam("name") String name, int age) { // 파라미터 이름(name)에 맞게 매개변수 선언
        System.out.println("name :" + name);
        System.out.println("age :" + age);

        // 리다이렉트
        return "redirect:/index";
    }

}
