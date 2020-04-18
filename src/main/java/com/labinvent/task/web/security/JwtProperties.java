package com.labinvent.task.web.security;


import org.springframework.http.HttpHeaders;

public class JwtProperties {

    // Test secret key, just for example!!
    public static final String SECRET = "TestTask";
    public static final int EXPIRATION_TIME = 864_000_000; // 10 days
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = HttpHeaders.AUTHORIZATION;
}
