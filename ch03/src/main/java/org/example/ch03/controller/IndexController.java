package org.example.ch03.controller;

import org.example.ch03.dto.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {

    @GetMapping(value = {"/", "/index"})
    public String index(Model model) {
        // System.out.println("index");

        // 템플릿 출력 변수
        int num1 = 123;
        double num2 = 2.12;
        String str1 = "Hello World";
        String str2 ="Hello Spring Boot";

        // DTO 생성 - 생성자 초기화
        UserDto user1 = new UserDto("a101", "김유신", "1999-01-01", 19); // @AllArgsConstructor
        System.out.println(user1); // toString() 호출


        // DTO 생성 - 세터 초기화
        UserDto user2 = new UserDto(); // @NoArgsConstructor
        user2.setUserid("a102");
        user2.setName("김춘추");
        user2.setBirth("1999-02-02");
        user2.setAge(22);
        System.out.println(user2);


        // DTO 생성 - 빌더 초기화
        UserDto user3 = UserDto.builder()
                                .userid("a103")
                                .name("장보고")
                                .birth("1999-03-03")
                                .age(23)
                                .build();
        System.out.println(user3);

        // 리스트  생성
        List<UserDto> dtoList = new ArrayList<>();
        dtoList.add(user1);
        dtoList.add(user2);
        dtoList.add(user3);

        // Model 참조 : Controller 컴포넌트 데이터를 View(HTML)에서 참조
        model.addAttribute("num1", num1);
        model.addAttribute("num2", num2);
        model.addAttribute("str1", str1);
        model.addAttribute("str2", str2);
        model.addAttribute("user1", user1);
        model.addAttribute("user2", user2);
        model.addAttribute("user3", user3);
        model.addAttribute("dtoList", dtoList);

        return "/index";
    }

}
