package org.example.springboot.domain.comments;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommentsRepositoryTest {

    @Autowired
    CommentsRepository commentsRepository;

    @After
    public void cleanup() {commentsRepository.deleteAll();}

    @Test
    public void voidTest(){

    }

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
