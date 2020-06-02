package com.ua.lviv.iot.puma560.service.impl;

import com.ua.lviv.iot.puma560.constant.ErrorMessage;
import com.ua.lviv.iot.puma560.exeption.InvalidUserRegistrationDataException;
import com.ua.lviv.iot.puma560.exeption.NotFoundException;
import com.ua.lviv.iot.puma560.model.Role;
import com.ua.lviv.iot.puma560.model.User;
import com.ua.lviv.iot.puma560.repository.RoleRepository;
import com.ua.lviv.iot.puma560.repository.UserRepository;
import com.ua.lviv.iot.puma560.service.UserService;
import com.ua.lviv.iot.puma560.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    final UserRepository userRepository;

    final Validator validator;

    final RoleRepository roleRepository;

    final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, Validator validator, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.validator = validator;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<User> findUserByEmail(String email) throws NotFoundException{

        Optional<User> user = userRepository.findByEmail(email);

        return user;
    }

    @Override
    public boolean validateUser(User user) {
        Map<String, String> map = new HashMap<>();

        if (!validator.validateEmail(user.getEmail())) {
            map.put("invalidEmail", ErrorMessage.INVALID_EMAIL);
        }
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            map.put("dublicationEmail", ErrorMessage.INVALID_USER_REGISTRATION_DATA);
        }
        if (map.isEmpty()) {
            return true;
        } else {
            throw new InvalidUserRegistrationDataException(map);
        }
    }

    @Override
    public boolean registerUser(User user) {
        Set<Role> roles = new HashSet<>();
        Role role = roleRepository.findByRole("USER");
        roles.add(role);
        user.setRoles(roles);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return true;
    }
}
