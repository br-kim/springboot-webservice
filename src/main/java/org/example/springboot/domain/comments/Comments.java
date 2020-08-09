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

    @ManyToOne(targetEntity = Posts.class, fetch = FetchType.LAZY)
    @JoinColumn(name="post_id")
    private Posts posts;


    @Builder
    public Comments(String content, String author, Long parentId, Posts posts){
        this.content = content;
        this.author = author;
        this.parentId = parentId;
        this.posts = posts;
    }

    public void update(String content){
        this.content = content;
    }
}
