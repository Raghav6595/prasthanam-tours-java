package com.prasthanam.tours;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * One-time utility to generate a BCrypt hash for your admin password.
 *
 * HOW TO USE:
 * 1. Change RAW_PASSWORD below to your desired admin password.
 * 2. Run: mvn test -Dtest=GeneratePasswordHashTest
 * 3. Copy the printed hash into the ADMIN_PASSWORD_HASH env var on Render.
 * 4. Change RAW_PASSWORD back to a placeholder (or delete this file) so the
 *    real password never sits in your repo/git history.
 */
class GeneratePasswordHashTest {

    private static final String RAW_PASSWORD = "Gopal@8770837247";

    @Test
    void generateHash() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String hash = encoder.encode(RAW_PASSWORD);
        System.out.println("=================================================");
        System.out.println("BCrypt hash for '" + RAW_PASSWORD + "':");
        System.out.println(hash);
        System.out.println("=================================================");
    }
}