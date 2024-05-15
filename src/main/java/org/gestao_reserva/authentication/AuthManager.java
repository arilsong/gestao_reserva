package org.gestao_reserva.authentication;

public class AuthManager {
    public static boolean authenticate(String email, String password) {
        return email.equals("arilson") && password.equals("12345");
    }
}
