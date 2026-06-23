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

public class CommentDTO {

    private int cno;
    private int parent; // 댓글의 부모 글 번호
    private String content;
    private String writer;
    private String wdate;

}
