package org.example.ch06.repository;

import jakarta.transaction.Transactional;
import lombok.extern.log4j.Log4j2;
import org.example.ch06.entity.board.Article;
import org.example.ch06.entity.board.Comment;
import org.example.ch06.entity.board.File;
import org.example.ch06.entity.board.User;
import org.example.ch06.repository.board.ArticleRepository;
import org.example.ch06.repository.board.CommentRepository;
import org.example.ch06.repository.board.FileRepository;
import org.example.ch06.repository.board.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@Log4j2
@SpringBootTest
class BoardRepositoryTest {
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private FileRepository fileRepository;
    @Autowired
    private UserRepository userRepository;

    @Test
    @DisplayName("사용자 추가")
    public void test1() {
        User user = User.builder()
                .userid("a101")
                .name("김유신")
                .birth("2000-01-01")
                .build();
        // JPA save()는 해당 엔티티를 INSERT한 다음 곧바로 SELECT로 조회해서 반환
        User savedUser = userRepository.save(user);

        System.out.println(savedUser);
    }

    @Test
    @DisplayName("글 등록")
    public void test2() {

        User user = User.builder().userid("a101").build();

        Article article = Article.builder()
                .title("제목")
                .content("내용")
                .user(user)
                .build();

        Article savedArticle = articleRepository.save(article);
    }

    @Test
    @DisplayName("댓글 등록")
    public void test3() {
        User user = User.builder()
                .userid("a101")
                .build();

        Article article = Article.builder()
                .ano(1)
                .build();

        Comment comment = Comment.builder()
                .content("댓글1")
                .article(article)
                .user(user)
                .build();

        Comment savedComment = commentRepository.save(comment);
        System.out.println(savedComment);

    }

    @Test
    @DisplayName("파일 등록")
    public void test4() {
        Article article = Article.builder()
                .ano(1)
                .build();

        File file = File.builder()
                .ofname("테스트2.txt")
                .sfname("abc456.txt")
                .article(article)
                .build();

        File savedFile = fileRepository.save(file);
        System.out.println(savedFile);
    }

    @Test
    @DisplayName("글 조회")
    public void test5() {
        List<Article> articleList = articleRepository.findAll();

        for(Article article : articleList) {
            System.out.println(article);
        }
    }

    @Test
    @DisplayName("특정 글 조회")
    @Transactional
    public void test6() {
       Optional<Article> optArticle = articleRepository.findById(1);
       if(optArticle.isPresent()) {
           Article article = optArticle.get();
           System.out.println(article);

           // getCommentList()로 Article 엔티티에 LAZY 모드인 commentList가 SELECT 됨
           // Article를 조회하는 SELECT와 Comment 조회하는 SELECT를 동시에 처리하기 위해 @Transactional 선언
           List<Comment> commentList = article.getCommentList();
           System.out.println(commentList);
       }
    }

    @Test
    @DisplayName("")
    public void test7() {
    }

}