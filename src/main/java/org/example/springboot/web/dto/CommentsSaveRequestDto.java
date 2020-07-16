package org.example.springboot.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.springboot.domain.comments.Comments;

@Getter
@NoArgsConstructor
public class CommentsSaveRequestDto {

    private String content;
    private String author;

    @Builder
    public CommentsSaveRequestDto(String title, String content, String author){
        this.content = content;
        this.author = author;
    }

    public Comments toEntity(){
        return Comments.builder()
                .content(content)
                .author(author)
                .build();
    }
}
