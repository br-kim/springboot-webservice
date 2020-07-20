package org.example.springboot.web.dto;

import lombok.Getter;
import org.example.springboot.domain.posts.Posts;

import java.time.LocalDateTime;

@Getter
public class PostsListResponseDto {

//메인 화면에서 모든 글을 불러오기 위한 Dto
    private Long id;
    private String title;
    private String author;
    private LocalDateTime modifiedDate;

    public PostsListResponseDto(Posts entity){
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.author = entity.getAuthor();
        this.modifiedDate = entity.getModifiedDate();
    }
}
