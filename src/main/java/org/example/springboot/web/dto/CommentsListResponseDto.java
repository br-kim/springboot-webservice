package org.example.springboot.web.dto;

import lombok.Getter;
import org.example.springboot.domain.comments.Comments;

import java.time.LocalDateTime;

@Getter
public class CommentsListResponseDto {

    private String author;
    private String content;
    private LocalDateTime modifiedDate;

    public CommentsListResponseDto(Comments entity){
        this.author = entity.getAuthor();
        this.content = entity.getContent();
        this.modifiedDate = entity.getModifiedDate();
    }
}
