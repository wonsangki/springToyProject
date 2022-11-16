package com.study.springstudy.controller.board;

import com.study.springstudy.entity.board.Post;
import com.study.springstudy.service.board.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {

    private final PostService postService;

    @GetMapping
    public ResponseEntity<Post> getPost(@RequestParam Long id) {
        try {
            Post post = postService.getPost(id);
            return new ResponseEntity<>(post, HttpStatus.OK);
        } catch (IllegalAccessException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public ResponseEntity<String> addNewPost(Post post){
        // validation check


        // save

        postService.savePost(post);

        return new ResponseEntity<>("글이 작성되었습니다.", HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<String> deletePost(@RequestParam Long id) {
        try {
            postService.deletePost(id);

            return new ResponseEntity<>("글을 삭제하였습니다.", HttpStatus.OK);
        } catch (IllegalAccessException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
