package com.study.springstudy.repository.board;

import com.study.springstudy.entity.board.Board;
import com.study.springstudy.entity.board.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    Optional<Post> findByIdAndIsDeletedIsFalse(Long id);

    Integer countByBoard(Board board);

    Optional<Page<Post>> findByBoardAndIsDeletedIsFalse(Board board, Pageable pageable);

}
