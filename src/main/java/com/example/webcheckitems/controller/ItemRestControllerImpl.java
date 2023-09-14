package com.example.webcheckitems.controller;

import com.example.webcheckitems.dto.CheckResponse;
import com.example.webcheckitems.dto.TextRequest;
import com.example.webcheckitems.exception.EmptyTextException;
import com.example.webcheckitems.service.CheckItemService;
import com.example.webcheckitems.util.ValidationResult;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

public abstract class ItemRestControllerImpl<S extends CheckItemService> implements ItemRestController {

    private final S service;

    protected ItemRestControllerImpl(S service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<CheckResponse> checkText(TextRequest text, BindingResult bindingResult) throws EmptyTextException {
        ValidationResult.valid(bindingResult);
        return ResponseEntity.ok(service.checkText(text.text()));
    }

}
