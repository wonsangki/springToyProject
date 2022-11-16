package com.study.springstudy.repository.board;

import com.study.springstudy.entity.board.Board;
import com.study.springstudy.entity.board.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {

    List<Board> findAllByIsDeletedIsFalseAndIsActivatedIsTrue();

}
