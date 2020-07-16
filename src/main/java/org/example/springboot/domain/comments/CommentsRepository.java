package org.example.springboot.domain.comments;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentsRepository extends JpaRepository<Comments, Long> {
    List<Comments> findByParentIdByOrderByIdDesc(Long parentId);
}
