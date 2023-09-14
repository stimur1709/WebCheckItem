package com.example.webcheckitems.controller;

import com.example.webcheckitems.dto.CheckResponse;
import com.example.webcheckitems.dto.TextRequest;
import com.example.webcheckitems.exception.EmptyTextException;
import com.example.webcheckitems.service.CheckBracketService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/checkBrackets")
public class BracketsRestController extends ItemRestControllerImpl<CheckBracketService> {

    @Autowired
    protected BracketsRestController(CheckBracketService service) {
        super(service);
    }

    @Override
    @Operation(summary = "Text checking for opening and closing pairs of brackets")
    public ResponseEntity<CheckResponse> checkText(TextRequest text, BindingResult bindingResult) throws EmptyTextException {
        return super.checkText(text, bindingResult);
    }
}
