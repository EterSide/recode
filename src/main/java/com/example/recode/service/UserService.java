package com.example.recode.service;

import com.example.recode.entity.User;
import com.example.recode.repository.UserRepositroy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepositroy userRepositroy;

    public void save(User user) {
        userRepositroy.save(user);
    }

    public Optional<User> getUser(Long id) {
        return userRepositroy.findById(id);
    }

}
