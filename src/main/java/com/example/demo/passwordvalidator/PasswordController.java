package com.example.demo.passwordvalidator;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PasswordController {

    private final PasswordService passwordService;

    public PasswordController(PasswordService passwordService) {
        this.passwordService = passwordService;
    }

    @PostMapping("/validate-password")
    public ResponseEntity<ValidationResult> validatePassword(@RequestBody PasswordRequest request) {
        ValidationResult validationResult = passwordService.validatePassword(request.getPassword());

        if (validationResult.isValid()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(validationResult, HttpStatus.BAD_REQUEST);
        }
    }
}
