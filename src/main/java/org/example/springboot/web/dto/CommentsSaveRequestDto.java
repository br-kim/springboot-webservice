package org.example.springboot.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.springboot.domain.comments.Comments;
import org.example.springboot.domain.posts.PostsRepository;


@Getter
@NoArgsConstructor
public class CommentsSaveRequestDto {


    private String content;
    private String author;
    private Long parentId;
    private PostsRepository postsRepository;


    @Builder
    public CommentsSaveRequestDto(String content, String author, Long parentId){
        this.content = content;
        this.author = author;
        this.parentId = parentId;
    }

    public Comments toEntity(){
        return Comments.builder()
                .content(content)
                .author(author)
                .parentId(parentId)
                .build();
    }
}
