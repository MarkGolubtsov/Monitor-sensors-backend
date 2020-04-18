package com.labinvent.task.web.security;




public class JwtProperties {
    private JwtProperties(){}
    // Test secret key, just for example!!
    public static final String SECRET = "TestTask";
    public static final int EXPIRATION_TIME = 864_000_000; // 10 days
    public static final String TOKEN_PREFIX = "Bearer ";
}
