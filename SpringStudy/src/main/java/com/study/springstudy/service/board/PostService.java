package com.study.springstudy.service.board;

import com.study.springstudy.entity.board.Post;
import com.study.springstudy.repository.board.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public Post getPost(Long id) throws IllegalAccessException {
        // validation check

        // find
        return postRepository.findByIdAndIsDeletedIsFalse(id)
                .orElseThrow(IllegalAccessException::new);
    }

    public void savePost(Post post){
        // validation check


        // save
        postRepository.save(post);
    }

    public void deletePost(Long id) throws IllegalAccessException {
        // validation check

        // delete
        Post post = postRepository.findById(id)
                .orElseThrow(IllegalAccessException::new);

        post.setIsDeleted(true);

        postRepository.save(post);
    }


}
