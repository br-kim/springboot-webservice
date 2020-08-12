package org.example.springboot.domain.comments;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.springboot.domain.BaseTimeEntity;
import org.example.springboot.domain.posts.Posts;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Comments extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    private Long parentId;

    @Builder
    public Comments(String content, String author, Long parentId){
        this.content = content;
        this.author = author;
        this.parentId = parentId;
    }

    public void update(String content){
        this.content = content;
    }
}
