package org.example.ch06.entity.board;

import jakarta.persistence.*;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "article")
@Builder
@Entity
@Table(name = "board_file")
public class File {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int fno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ano")
    private Article article;
    // private  int ano; // 해당 파일이 첨부된 글 번호

    private String ofname;
    private String sfname;


}
