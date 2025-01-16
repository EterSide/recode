package com.example.recode.controiler;

import com.example.recode.entity.User;
import com.example.recode.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/save")
    public void save(@RequestBody User user) {
        User u = new User();
        u.setUser_id(user.getUser_id());
        u.setEmail(user.getEmail());
        u.setPassword(user.getPassword());
        u.setRecodes(user.getRecodes());
        userService.save(u);
    }

}
