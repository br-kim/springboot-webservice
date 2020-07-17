package org.example.springboot.web;

import lombok.RequiredArgsConstructor;
import org.example.springboot.service.comments.CommentsService;
import org.example.springboot.web.dto.CommentsSaveRequestDto;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class CommentApiController {

    private final CommentsService commentsService;

    @PostMapping("/api/v1/comments")
    public Long save(@RequestBody CommentsSaveRequestDto requestDto)
    {
        return commentsService.save(requestDto);
    }

    @DeleteMapping("/api/v1/comments/{id}")
    public Long delete(@PathVariable Long id){
        commentsService.delete(id);
        return id;
    }
}
