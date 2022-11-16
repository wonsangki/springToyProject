package com.study.springstudy.controller.board;

import com.study.springstudy.entity.board.Board;
import com.study.springstudy.entity.board.Post;
import com.study.springstudy.service.board.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    @GetMapping
    public ResponseEntity<List<Post>> getPostList() {
        List<Post> posts = new ArrayList<>();

        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<String> addNewBoard(Board board) {
        boardService.addNewBoard(board);

        return new ResponseEntity<>("게시판이 추가되었습니다.", HttpStatus.OK);

    }
}
