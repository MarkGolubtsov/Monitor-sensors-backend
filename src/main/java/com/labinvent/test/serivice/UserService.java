package com.labinvent.test.serivice;

import com.labinvent.test.serivice.dto.UserDTO;

public interface UserService {
    UserDTO findByEmailAndPassword(String email,String password);
    UserDTO findByEmail(String email);
}
