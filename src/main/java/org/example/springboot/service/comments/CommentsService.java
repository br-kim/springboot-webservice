package org.example.springboot.service.comments;

import lombok.RequiredArgsConstructor;
import org.example.springboot.config.auth.LoginUser;
import org.example.springboot.config.auth.dto.SessionUser;
import org.example.springboot.domain.comments.Comments;
import org.example.springboot.domain.comments.CommentsRepository;
import org.example.springboot.web.dto.CommentsListResponseDto;
import org.example.springboot.web.dto.CommentsSaveRequestDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CommentsService {

    private final CommentsRepository commentsRepository;

    @Transactional
    public Long save(CommentsSaveRequestDto requestDto){
        return commentsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, CommentsSaveRequestDto requestDto){
        Comments comments = commentsRepository.findById(id).orElseThrow(()->
        new IllegalArgumentException("해당 댓글이 없습니다. id="+id));
        comments.update(requestDto.getContent());

        return id;
    }

    @Transactional(readOnly = true)
    public List<CommentsListResponseDto> findByParentIdByOrderByIdDesc(Long id){
        return commentsRepository.findByParentIdByOrderByIdDesc(id).stream()
                .map(CommentsListResponseDto::new)
                .collect(Collectors.toList());
    }


    @Transactional
    public void delete(Long id, @LoginUser SessionUser user){
        Comments comments = commentsRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("해당 댓글이 없습니다. id="+id));
        if (user.getName().equals(comments.getAuthor())) {
            commentsRepository.delete(comments);
        }
        else{
            throw new IllegalAccessError("본인의 댓글만 삭제 가능합니다.");
        }

    }


}
