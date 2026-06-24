package org.example.ch08.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import org.example.ch08.entity.User1;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class User1DTO {

    private String userid;
    private String name;
    private String hp;
    private int age;

    public User1 toEntity(){
        return User1.builder()
                .userid(userid)
                .name(name)
                .hp(hp)
                .age(age)
                .build();
    }

}