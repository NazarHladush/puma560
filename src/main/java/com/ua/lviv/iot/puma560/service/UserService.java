package com.ua.lviv.iot.puma560.service;

import com.ua.lviv.iot.puma560.exeption.NotFoundException;
import com.ua.lviv.iot.puma560.model.User;

import java.util.Optional;

public interface UserService {

    Optional<User> findUserByEmail (String email) throws NotFoundException;
}
