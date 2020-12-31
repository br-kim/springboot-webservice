package org.example.springboot.domain.comments;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CommentsRepositoryTest {

    @Autowired
    CommentsRepository commentsRepository;

    @AfterEach
    public void cleanup() {commentsRepository.deleteAll();}

    @Test
    public void 댓글저장_불러오기(){

        String content = "댓글 본문";

        commentsRepository.save(Comments.builder()
        .content(content)
        .author("idle947@gmail.com")
        .build());

        //when
        List<Comments> commentsList = commentsRepository.findAll();

        //then
        Comments comments = commentsList.get(0);
        assertThat(comments.getContent()).isEqualTo(content);


    }
}
