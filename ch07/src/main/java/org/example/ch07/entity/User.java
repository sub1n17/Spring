package org.example.ch07.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.example.ch07.dto.UserDTO;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
public class User {

    @Id
    private String userid;
    private String pass;
    private String name;
    private String birth;
    private int age;
    private String role; // 권한

    @CreationTimestamp
    private LocalDateTime rdate;

    // DTO 변환 메서드
    public UserDTO toDTO(){
        return UserDTO.builder()
                .userid(userid)
                .pass(pass)
                .name(name)
                .birth(birth)
                .age(age)
                .role(role)
                .rdate(rdate.toString())
                .build();
    }

}