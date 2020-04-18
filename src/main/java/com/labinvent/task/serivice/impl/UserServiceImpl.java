package com.labinvent.task.serivice.impl;

import com.labinvent.task.repository.UserRepository;
import com.labinvent.task.repository.entity.User;
import com.labinvent.task.serivice.UserService;
import com.labinvent.task.serivice.dto.UserConverter;
import com.labinvent.task.serivice.dto.UserDTO;
import com.labinvent.task.serivice.exception.NotFoundEntityException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private static final String NOT_FOUND = "User not found.";
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDTO findByEmailAndPassword(String email, String password) {
        Optional<User> optionalUser = userRepository.findByEmailAndPassword(email, password);
        if (optionalUser.isPresent()) {
            return UserConverter.toDTO(optionalUser.get());
        }
        throw new NotFoundEntityException(NOT_FOUND);
    }

    @Override
    public UserDTO findByEmail(String email) {
        Optional<User> optionalUser = userRepository.findByEmail(email);
        if (optionalUser.isPresent()) {
            return UserConverter.toDTO(optionalUser.get());
        }
        throw new NotFoundEntityException(NOT_FOUND);
    }
}
