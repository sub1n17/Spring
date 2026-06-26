package org.example.ch09.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.example.ch09.dto.UserDTO;
import org.example.ch09.entity.User;
import org.example.ch09.jwt.JwtProvider;
import org.example.ch09.security.MyUserDetails;
import org.example.ch09.service.UserService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.util.List;
import java.util.Map;


@Log4j2
@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService service;
    private final AuthenticationManager authenticationManager;
    private final JwtProvider jwtProvider;

    //@ResponseBody
    @PostMapping("/user")
    public ResponseEntity<UserDTO> register(@RequestBody UserDTO dto){
        log.info(dto);

        UserDTO savedUser1 = service.register(dto);

        // 응답 객체 생성
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedUser1);
    }

    @PostMapping("/login")
    public ResponseEntity<UserDTO> login(@RequestBody UserDTO dto, HttpServletResponse response){

        // 시큐리티 인증 처리
        UsernamePasswordAuthenticationToken authToken =
                new UsernamePasswordAuthenticationToken(dto.getUserid(), dto.getPass());

        Authentication authentication = authenticationManager.authenticate(authToken);
        MyUserDetails details = (MyUserDetails) authentication.getPrincipal();
        User user = details.getUser();
        log.info(user);

        // 토큰 생성
        String accessToken = jwtProvider.createToken(user, 1);
        String refreshToken = jwtProvider.createToken(user, 5);
        log.info(accessToken);

        // Refresh 토큰 DB 저장

        // 쿠키 생성
        Cookie cookie1 = new Cookie("AUTH-TOKEN", accessToken);
        cookie1.setHttpOnly(true);   // 자바스크립트로 쿠키 접근 차단(XSS 방어)
        cookie1.setSecure(false);     // HTTPS 통신에서만 쿠키 전송, 테스트 -> false, 운영배포 -> true
        cookie1.setPath("/");
        cookie1.setMaxAge(60 * 60 * 24); // 24시간(1일)

        Cookie cookie2 = new Cookie("REFRESH-TOKEN", refreshToken);
        cookie2.setHttpOnly(true);   // 자바스크립트로 쿠키 접근 차단(XSS 방어)
        cookie2.setSecure(false);     // HTTPS 통신에서만 쿠키 전송, 테스트 -> false, 운영배포 -> true
        cookie2.setPath("/");
        cookie2.setMaxAge(60 * 60 * 24 * 5); // 5일

        // 응답 객체로 쿠키 전송
        response.addCookie(cookie1);
        response.addCookie(cookie2);

        return ResponseEntity.ok(user.toDTO());

    }

    @GetMapping("/logout")
    public ResponseEntity logout(HttpServletResponse response){
        // DB에 저장된 refreshToken 삭제

        // 시큐리티 인증 객체 제거
        SecurityContextHolder.clearContext();

        // 쿠키 삭제
        Cookie cookie1 = new Cookie("AUTH-TOKEN", null);
        cookie1.setPath("/");
        cookie1.setMaxAge(0);

        Cookie cookie2 = new Cookie("REFRESH-TOKEN", null);
        cookie2.setPath("/");
        cookie2.setMaxAge(0);

        response.addCookie(cookie1);
        response.addCookie(cookie2);

        return ResponseEntity.ok(
                Map.of("result", true)
        );
    }


    @GetMapping("/user")
    public ResponseEntity<UserDTO> user(){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        log.info(authentication);

        MyUserDetails details = (MyUserDetails) authentication.getPrincipal();
        User user = details.getUser();

        log.info(user);

        UserDTO userDTO = service.getUser(user.getUserid());

        return ResponseEntity.ok(userDTO);
    }

}