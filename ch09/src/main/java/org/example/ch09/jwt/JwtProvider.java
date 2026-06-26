package org.example.ch09.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SecurityException;
import io.jsonwebtoken.security.SignatureException;
import lombok.Getter;
import org.example.ch09.entity.User;
import org.example.ch09.security.MyUserDetails;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.time.Duration;
import java.util.Date;

@Getter
@Component
public class JwtProvider {

    private String issuer;
    private SecretKey secret;

    // application.yml 파일 설정값으로 초기화
    public JwtProvider(@Value("${jwt.issuer}") String issuer,
                       @Value("${jwt.secret}") String secret) {
        this.issuer = issuer;
        this.secret = Keys.hmacShaKeyFor(secret.getBytes());
    }


    public String createToken(User user, int day) {

        // 발급일, 만료일 생성
        Date issuedDate = new Date();
        Date expireDate = new Date(issuedDate.getTime() + Duration.ofDays(day).toMillis());

        // 토큰 생성
        String jwt = Jwts.builder()
                .issuer(issuer)
                .issuedAt(issuedDate)
                .expiration(expireDate)
                .claim("username", user.getUserid())
                .claim("role", user.getRole())
                .signWith(secret)
                .compact();
        return jwt;
    }

    public Claims getClaims(String token) {
        return Jwts
                .parser()
                .verifyWith(secret)
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public Authentication getAuthentication(String token) {
        // 토큰에서 사용자 정보 구하기
        Claims claims = getClaims(token);
        String username = (String) claims.get("username");
        String role = (String) claims.get("role");

        // 엔티티 생성
        User user = User.builder()
                .userid(username)
                .role(role)
                .build();

        MyUserDetails details = MyUserDetails.builder()
                .user(user)
                .build();

        return new UsernamePasswordAuthenticationToken(details, token, details.getAuthorities());
    }

    public void validateToken(String token) {
        try {
            Jwts.parser()
                    .verifyWith(secret)
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();

        } catch (ExpiredJwtException e) {
            throw new RuntimeException("토큰이 만료 되었습니다.");
        } catch (SignatureException e) {
            throw new RuntimeException("토큰 서명이 잘못 되었습니다.");
        } catch (JwtException e) {
            throw new RuntimeException("유효하지 않은 토큰 입니다.");
        } catch (Exception e) {
            throw new RuntimeException("토큰 검증에 실패했습니다.");
        }
    }

}