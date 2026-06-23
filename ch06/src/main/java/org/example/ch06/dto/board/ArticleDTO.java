package org.example.ch06.dto.board;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder

public class ArticleDTO {

    private int ano;
    private String title;
    private String content;
    private String writer;
    private int file;
    private String wdate;
}
