package org.example.ch06.entity.board;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "board_user")
public class User {


    @Id
    private String userid;
    
    private String name;
    private String birth;

    @CreationTimestamp
    private LocalDateTime rdate;

}
