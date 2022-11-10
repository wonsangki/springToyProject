package com.study.springstudy.entity.board;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
public class Post {
    @Id
    @GeneratedValue
    private Long id;
}
