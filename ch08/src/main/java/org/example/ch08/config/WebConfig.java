package org.example.ch08.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {

        /*
            CORS
            - 웹 애플리케이션에서 다른 도메인의 리소스에 접근을 허용하지 않는 HTTP 정책
            - 기본적으로 보안상의 이유로 다른 도메인 리소스 접근은 금지
            - REST API 서비스를 하기 위해서는 CORS 정책을 허용해야 됨
         */

        registry
                .addMapping("/**") // 엔드포인트에 대한 CORS 허용
                .allowedOriginPatterns("http://localhost:5500", "http://127.0.0.1:5500")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true)
                .maxAge(3600);
    }
}
