package org.example.ch03.dto;


import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor // 모든 속성으로 생성자 생성
@NoArgsConstructor
//@RequiredArgsConstructor
@Builder
//@Data (@Getter + @Setter + @ToString + @RequiredArgsConstructor 통합)
public class UserDto {

    private String userid;
    private String name;
    private String birth;
    private int age;

}
