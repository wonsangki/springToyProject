package com.study.springstudy.repository.board;

import com.study.springstudy.entity.board.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findAllByPostIdAndIsDeletedIsFalse(Long postId);




}
