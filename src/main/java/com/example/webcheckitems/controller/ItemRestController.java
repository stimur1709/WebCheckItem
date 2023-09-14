package com.example.webcheckitems.controller;

import com.example.webcheckitems.dto.CheckResponse;
import com.example.webcheckitems.dto.TextRequest;
import com.example.webcheckitems.exception.EmptyTextException;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface ItemRestController {

    @PostMapping
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Check completed"),
            @ApiResponse(responseCode = "400", description = "Check failed, text is empty")
    })
    ResponseEntity<CheckResponse> checkText(@Valid @RequestBody TextRequest text, BindingResult bindingResult) throws EmptyTextException;

}
