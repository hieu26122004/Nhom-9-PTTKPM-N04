package com.nhson.authservice.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Map;

public class LoginRequestValidator implements ConstraintValidator<ValidLoginRequest, Map<String,String>> {
    @Override
    public boolean isValid(Map<String, String> requestBody, ConstraintValidatorContext context) {
        if(requestBody == null){
            return false;
        }

        String username = requestBody.get("username");
        String password = requestBody.get("password");

        if(username == null || username.isBlank()){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Username is required").addConstraintViolation();
        }

        if (password == null || password.isBlank()) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Password is required")
                    .addConstraintViolation();
            return false;
        }

        return true;
    }
}