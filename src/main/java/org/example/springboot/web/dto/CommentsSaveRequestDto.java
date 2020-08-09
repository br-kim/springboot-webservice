package org.example.springboot.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.springboot.domain.comments.Comments;
import org.example.springboot.domain.posts.Posts;
import org.example.springboot.domain.posts.PostsRepository;
import org.example.springboot.service.posts.PostsService;

import java.util.Optional;

@Getter
@NoArgsConstructor
public class CommentsSaveRequestDto {

    private Posts posts;
    private String content;
    private String author;
    private Long parentId;
    private Long postId;
    PostsService postsService;
    PostsRepository postsRepository;


    @Builder
    public CommentsSaveRequestDto(String content, String author, Long parentId, Long postId){
        this.content = content;
        this.author = author;
        this.parentId = parentId;
        this.postId = postId;
        this.posts = postsRepository.findById(postId).orElseThrow(() -> new
                IllegalArgumentException("해당 게시글이 없습니다. id="+postId));
    }

    public Comments toEntity(){
        return Comments.builder()
                .content(content)
                .author(author)
                .parentId(parentId)
                .posts(postsRepository.findById(postId).orElseThrow(() -> new
                        IllegalArgumentException("해당 게시글이 없습니다. id="+postId)))
                .build();
    }
}
