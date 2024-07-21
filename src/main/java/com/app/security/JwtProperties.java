package com.app.security;

public class JwtProperties {
    public static final String SECRET = "SecretKey";
    public static final long EXPIRATION_TIME = 86400000;
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
}
