package org.example.ch04.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User1DTO {

    private String userid;
    private String name;
    private String hp;
    private int age;
}
