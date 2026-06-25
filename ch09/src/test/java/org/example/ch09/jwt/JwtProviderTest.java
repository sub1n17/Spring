package org.example.ch09.jwt;

import io.jsonwebtoken.Claims;
import lombok.extern.log4j.Log4j2;
import org.antlr.v4.runtime.Token;
import org.example.ch09.entity.User;
import org.example.ch09.security.MyUserDetails;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.Authentication;

import static org.junit.jupiter.api.Assertions.*;

@Log4j2
@SpringBootTest
class JwtProviderTest {
    @Autowired
    private JwtProvider provider;


    @Test
    void createToken() {

        User user = User.builder()
                .userid("a101")
                .name("1")
                .birth("2000-01-01")
                .age(23)
                .role("ADMIN")
                .build();
        String access = provider.createToken(user, -1);
       // String refresh = provider.createToken(user, 5);
        log.info(access);
        // log.info(refresh);
    }

    @Test
    void getClaims() {

        String token = "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJzdWIxbjE3QG5hdmVyLmNvbSIsImlhdCI6MTc4MjM3MDk5MywiZXhwIjoxNzgyNDU3MzkzLCJ1c2VybmFtZSI6ImExMDEiLCJyb2xlIjoiQURNSU4ifQ.Iw0yF3DI-2vBagrQgrNitQrqUqcOBH_sGfnC1p9LzHw";

        Claims claims = provider.getClaims(token);
        String username = (String) claims.get("username");
        String role = (String) claims.get("role");

        log.info("username" + username);
        log.info("role" + role);

    }

    @Test
    void getAuthentication() {
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJzdWIxbjE3QG5hdmVyLmNvbSIsImlhdCI6MTc4MjM3MDk5MywiZXhwIjoxNzgyNDU3MzkzLCJ1c2VybmFtZSI6ImExMDEiLCJyb2xlIjoiQURNSU4ifQ.Iw0yF3DI-2vBagrQgrNitQrqUqcOBH_sGfnC1p9LzHw";

        Authentication authentication = provider.getAuthentication(token);
        User user = (User) authentication.getPrincipal();

        //  User user = details.getUser();
        log.info(user);

    }

    @Test
    void validateToken() {
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJzdWIxbjE3QG5hdmVyLmNvbSIsImlhdCI6MTc4MjM3MDk5MywiZXhwIjoxNzgyNDU3MzkzLCJ1c2VybmFtZSI6ImExMDEiLCJyb2xlIjoiQURNSU4ifQ.Iw0yF3DI-2vBagrQgrNitQrqUqcOBH_sGfnC1p9LzHw";

        provider.validateToken(token);
    }

    @Test
    void getIssuer() {
    }

    @Test
    void getSecret() {
    }
}