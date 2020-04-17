package com.labinvent.test.serivice.impl;

import com.labinvent.test.repository.UserRepository;
import com.labinvent.test.repository.entity.User;
import com.labinvent.test.serivice.UserService;
import com.labinvent.test.serivice.dto.UserConverter;
import com.labinvent.test.serivice.dto.UserDTO;
import com.labinvent.test.serivice.exception.NotFoundEntityException;
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
    public UserDTO findByEmail(String email) {
        Optional<User> optionalUser = userRepository.findByEmail(email);
        if (optionalUser.isPresent()) {
            return UserConverter.toDTO(optionalUser.get());
        }
        throw new NotFoundEntityException("User not found.");
    }

}
