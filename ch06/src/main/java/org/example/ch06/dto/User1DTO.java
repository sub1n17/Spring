package org.example.ch06.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.example.ch06.entity.User1;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class User1DTO {
    private String userid;
    private String name;
    private String hp;
    private int age;

    // Entity 변환 메서드
    public User1 toEntity(){
        return User1.builder()
                .userid(userid)
                .name(name)
                .hp(hp)
                .age(age)
                .build();
    }
}