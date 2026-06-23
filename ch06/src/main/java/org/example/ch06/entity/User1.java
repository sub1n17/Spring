package org.example.ch06.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.example.ch06.dto.User1DTO;

@Getter
//@Setter Entity에서는 Setter 금지
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity                 // User1 엔티티 정의, 생략 불가능
@Table(name = "user1")  // 매핑 테이블 설정, 생략가능
public class User1 {
    @Id                     // 테이블 PK 속성 선언
    private String userid;

    @Column(name = "name")  // 테이블 매핑 설정, 생략 가능
    private String name;

    @Column(name = "hp")
    private String hp;
    private int age;

    // DTO 변환 메서드
    public User1DTO toDTO(){
        return User1DTO.builder()
                .userid(userid)
                .name(name)
                .hp(hp)
                .age(age)
                .build();
    }


}