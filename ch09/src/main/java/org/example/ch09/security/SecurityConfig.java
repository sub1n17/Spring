package org.example.ch09.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer;
import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/*
    스프링 시큐리티 설정 클래스
    - 인증 및 인가 처리 설정
    - 기타 시큐리티 설정
 */

@EnableMethodSecurity
@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        // 로그인 설정
        // 토큰 기반 인증 시큐리티 설정
        httpSecurity.csrf(CsrfConfigurer::disable)
                .httpBasic(HttpBasicConfigurer::disable)
                .formLogin(FormLoginConfigurer::disable)
                .sessionManagement(config -> config.sessionCreationPolicy(SessionCreationPolicy.STATELESS));



        // 인가 설정
//        httpSecurity.authorizeHttpRequests(authorize -> authorize
//                .requestMatchers("/").permitAll() // 루트(/) 경로는 인증없이 모든 요청 허용
//                .requestMatchers("/admin/**").hasRole("ADMIN")
//                .requestMatchers("/manager/**").hasAnyRole("ADMIN", "MANAGER")
//                .requestMatchers("/member/**").hasAnyRole("ADMIN", "MANAGER", "MEMBER")
//                .anyRequest().permitAll()
//        );


        return httpSecurity.build();



    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        // 시큐리티에서 사용하는 비밀번호 생성기
        return new BCryptPasswordEncoder();
    }

}
