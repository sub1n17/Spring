package org.example.ch04.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User3DTO {

    private String userid;
    private String name;
    private String birth;
    private String hp;
    private String addr;

}
