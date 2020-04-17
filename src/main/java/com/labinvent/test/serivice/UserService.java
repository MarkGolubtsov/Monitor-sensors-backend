package com.labinvent.test.serivice;

import com.labinvent.test.serivice.dto.UserDTO;

public interface UserService {
    UserDTO findByEmail(String email);
}
