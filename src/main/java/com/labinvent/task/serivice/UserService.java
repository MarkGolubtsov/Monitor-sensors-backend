package com.labinvent.task.serivice;

import com.labinvent.task.serivice.dto.UserDTO;

public interface UserService {
    UserDTO findByEmailAndPassword(String email, String password);

    UserDTO findByEmail(String email);
}
