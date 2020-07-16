package org.example.springboot.web;

import lombok.RequiredArgsConstructor;
import org.example.springboot.service.comments.CommentsService;
import org.example.springboot.web.dto.CommentsSaveRequestDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class CommentApiController {

    private final CommentsService commentsService;

    @PostMapping("/api/v1/comments")
    public Long save(@RequestBody CommentsSaveRequestDto requestDto)
    {
        return commentsService.save(requestDto);
    }

}
