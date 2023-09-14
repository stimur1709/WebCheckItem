package com.example.webcheckitems.util;

import com.example.webcheckitems.exception.EmptyTextException;
import org.springframework.validation.BindingResult;

import java.util.Objects;

public class ValidationResult {

    private ValidationResult() {

    }

    public static void valid(BindingResult bindingResult) throws EmptyTextException {
        if (bindingResult.hasErrors()) {
            throw new EmptyTextException(Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
        }
    }

}
