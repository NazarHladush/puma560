package com.ua.lviv.iot.puma560.controller;

import com.ua.lviv.iot.puma560.model.User;
import com.ua.lviv.iot.puma560.repository.UserRepository;
import com.ua.lviv.iot.puma560.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/registration")
public class RegistrationController {

    final
    UserRepository userRepository;

    final
    UserService userService;

    public RegistrationController(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @PostMapping
    public HttpStatus registration(@RequestBody User user) {
        userService.validateUser(user);
        userService.registerUser(user);
        return HttpStatus.OK;
    }

    @GetMapping
    public User registrdation() {
        return new User();
    }
}
