package com.example.demo.passwordvalidator;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PasswordService {

    public ValidationResult validatePassword(String password) {
        List<String> errors = new ArrayList<>();

        if (password.length() < 8) {
            errors.add("A senha deve ter pelo menos 8 caracteres.");
        }

        if (!containsUppercaseLetter(password)) {
            errors.add("A senha deve conter pelo menos uma letra maiúscula.");
        }

        if (!containsLowercaseLetter(password)) {
            errors.add("A senha deve conter pelo menos uma letra minúscula.");
        }

        if (!containsDigit(password)) {
            errors.add("A senha deve conter pelo menos um dígito numérico.");
        }

        if (!containsSpecialCharacter(password)) {
            errors.add("A senha deve conter pelo menos um caractere especial (!@#$%).");
        }

        return new ValidationResult(errors.isEmpty(), errors);
    }

    private boolean containsUppercaseLetter(String password) {
        return password.matches(".*[A-Z].*");
    }

    private boolean containsLowercaseLetter(String password) {
        return password.matches(".*[a-z].*");
    }

    private boolean containsDigit(String password) {
        return password.matches(".*\\d.*");
    }

    private boolean containsSpecialCharacter(String password) {
        return password.matches(".*[!@#\\$%].*");
    }
}
