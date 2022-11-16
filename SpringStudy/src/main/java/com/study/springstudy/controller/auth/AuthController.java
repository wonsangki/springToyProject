package com.study.springstudy.controller.auth;

import com.study.springstudy.entity.auth.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping
    public ResponseEntity<String> joinUser(User user) {

        return new ResponseEntity<>("", HttpStatus.OK);
    }
}
