package com.labinvent.task.web.controller;

import com.labinvent.task.serivice.UserService;
import com.labinvent.task.serivice.dto.UserDTO;
import com.labinvent.task.serivice.dto.UserLogin;
import com.labinvent.task.web.Token;
import com.labinvent.task.web.security.JwtProperties;
import io.fusionauth.jwt.Signer;
import io.fusionauth.jwt.domain.JWT;
import io.fusionauth.jwt.hmac.HMACSigner;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;

@RestController
public class UserController {

    private static final String ROLE_CLAIM = "role";

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/login")
    public Token login(@RequestBody UserLogin userLogin) {
        UserDTO userDTO = userService.findByEmailAndPassword(userLogin.getEmail(), userLogin.getPassword());
        Token token = new Token();
        token.setToken(generateToken(userDTO.getEmail(), userDTO.getRole()));
        return token;
    }

    private String generateToken(String subject, String role) {
        Signer signer = HMACSigner.newSHA512Signer(JwtProperties.SECRET);
        JWT jwt = new JWT()
                .addClaim(ROLE_CLAIM, role)
                .setIssuedAt(ZonedDateTime.now(ZoneOffset.UTC))
                .setSubject(subject)
                .setExpiration(ZonedDateTime.now(ZoneOffset.UTC).plusMinutes(JwtProperties.EXPIRATION_TIME / 60));
        return JWT.getEncoder().encode(jwt, signer);
    }
}
