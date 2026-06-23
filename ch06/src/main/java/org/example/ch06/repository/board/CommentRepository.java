package org.example.ch06.repository.board;

import org.example.ch06.entity.board.Article;
import org.example.ch06.entity.board.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {




}
