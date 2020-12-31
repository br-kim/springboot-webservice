package org.example.springboot.web.dto;

import org.example.springboot.domain.posts.Posts;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PostsResponseDtoTest {

    @Test
    public void 게시글_DTO_테스트(){
        //given
        String title = "제목";
        String content = "내용";
        String author = "idle947@gmail.com";

        //when
        Posts entity = Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();

        PostsResponseDto postsResponseDto = new PostsResponseDto(entity);

        //then
        assertThat(postsResponseDto.getTitle()).isEqualTo(title);
        assertThat(postsResponseDto.getContent()).isEqualTo(content);
        assertThat(postsResponseDto.getAuthor()).isEqualTo(author);
    }

}
