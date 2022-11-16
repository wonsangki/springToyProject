package com.study.springstudy.controller;

import com.study.springstudy.dto.auth.UserDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class MainController {
    @GetMapping("/")
    public ResponseEntity<String> main(){
        return new ResponseEntity<>("OK THANK YOU", HttpStatus.OK);
    }

    @PostMapping("/user/add")
    public ResponseEntity<String> addUser(UserDto userDto) {



        return new ResponseEntity<>("ADD NEW USER", HttpStatus.OK);
    }
}
