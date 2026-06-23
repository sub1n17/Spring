package org.example.ch07.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import org.example.ch07.entity.User;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class UserDTO {

    private String userid;
    private String pass;
    private String name;
    private String birth;
    private int age;
    private String role; // 권한
    private String rdate;

    // Entity 변환 메서드
    public User toEntity(){
        return User.builder()
                .userid(userid)
                .pass(pass)
                .name(name)
                .birth(birth)
                .age(age)
                .role(role)
                .build();
    }


}