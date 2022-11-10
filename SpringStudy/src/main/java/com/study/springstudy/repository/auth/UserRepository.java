package com.study.springstudy.repository.auth;

import com.study.springstudy.entity.auth.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {
    public User findOne(long id);
}
