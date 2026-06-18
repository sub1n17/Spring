package org.example.ch04.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.ch04.dto.User1DTO;
import org.example.ch04.service.User1Service;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Slf4j // Simple Log Facade For Java, Lombok이 로그 객체를 자동 생성해주는 어노테이션
@RequiredArgsConstructor
@Controller
public class User1Controller {

    // ⭐ @RequiredArgsConstructor으로 의존객체 주입
    private final User1Service service;

    @GetMapping("/log")
    public String log() {
        /*
            로그 레벨
            DEBUG - 가장 낮은 단계 레벨, 개발용으로 사용, 시스템(WAS)에서도 DEBUG 로그 출력하기 때문에 사용자 DEBUG 로그 사용 불편
            INFO - 실질적으로 사용자가 사용하는 로그 레벨
            WARN -  잠재적인 에러가 발생할 로직에 사용하는 로그 레벨
            ERROR - 명백한 에러가 발생할 로직에 사용하는 로그 레벨, try-catch에서 catch절에 사용
        */


        log.debug("log - debug...");
        log.info("log - info...");
        log.warn("log - warn...");
        log.error("log - error...");

        return "redirect:/";
    }


    @GetMapping("/user1/list")
    public String list(Model model) {

        // 조회 서비스 요청
        List<User1DTO> dtoList = service.getAll();

        // 모델 참조 : 뷰(HTML)에서 컨트롤러 데이터 참조
        model.addAttribute("dtoList", dtoList);

        return "user1/list";
    }

    @GetMapping("/user1/register")
    public String register() {
        return "user1/register";
    }

    @PostMapping("/user1/register")
    public String register(User1DTO dto) {
        // System.out.println(dto);
        log.info(dto.toString());

        // 등록 서비스 호출
        service.register(dto);
        return "redirect:/user1/list?register=success";
    }

    @GetMapping("/user1/modify")
    public String modify(String userid, Model model) {
        // System.out.println(userid);
        log.info(userid);

        // 수정 조회 서비스 호출
        User1DTO dto = service.getById(userid);

        // 모델 참조
        model.addAttribute(dto); // 키값 생락하면 해당 객체 소문자로 시작하는 타입명 ("user1DTO", dto)

        return "user1/modify";
    }

    @PostMapping("/user1/modify")
    public String modify(User1DTO dto) {
        // System.out.println(dto);
        log.info(dto.toString());

        // 수정 서비스 요청
        service.modify(dto);

        // 수정 후 목록 이동
        return "redirect:/user1/list?modify=success";
    }

    @GetMapping("/user1/remove")
    public String remove(String userid) {
        // 삭제 서비스 요청
        service.remove(userid);

        // 삭제 후 목록 이동
        return "redirect:/user1/list?remove=success";
    }

}
