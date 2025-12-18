package com.xiaoniucode.timeline.trail.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author liuxin
 */
public class PasswordUtil {
    private static final BCryptPasswordEncoder ENCODER = new BCryptPasswordEncoder();

    public static String encode(String rawPassword) {
        return ENCODER.encode(rawPassword);
    }

    public static boolean matches(String rawPassword, String encodedPassword) {
        return ENCODER.matches(rawPassword, encodedPassword);
    }

    public static void main(String[] args) {
        String rawPassword = "123456";
        String encodedPassword = encode(rawPassword);
        System.out.println(encodedPassword);
    }
}
