package org.example.ch04.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User5DTO {

    private int seq;
    private String name;
    private String gender;
    private int age;
    private String addr;

}
