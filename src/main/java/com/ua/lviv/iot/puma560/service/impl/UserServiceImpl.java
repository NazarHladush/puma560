package com.ua.lviv.iot.puma560.service.impl;

import com.ua.lviv.iot.puma560.exeption.NotFoundException;
import com.ua.lviv.iot.puma560.model.User;
import com.ua.lviv.iot.puma560.repository.UserRepository;
import com.ua.lviv.iot.puma560.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl (UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> findUserByEmail(String email) throws NotFoundException{

        Optional<User> user = userRepository.findByEmail(email);

        return user;
    }
}
