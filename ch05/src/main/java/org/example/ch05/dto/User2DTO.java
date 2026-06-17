package org.example.ch05.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User2DTO {

    private String userid;
    private String name;
    private String birth;
    private String addr;

}
