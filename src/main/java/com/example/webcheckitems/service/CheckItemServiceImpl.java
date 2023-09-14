package com.example.webcheckitems.service;

import com.example.webcheckitems.cheker.CheckItemImpl;
import com.example.webcheckitems.dto.CheckResponse;
import com.example.webcheckitems.exception.EmptyTextException;
import lombok.AllArgsConstructor;


@AllArgsConstructor
public class CheckItemServiceImpl<C extends CheckItemImpl> implements CheckItemService {

    private final C checker;
    @Override
    public CheckResponse checkText(String text) throws EmptyTextException {
        if (text == null || text.isBlank()) {
            throw new EmptyTextException("Test is empty");
        }
        return new CheckResponse(checker.check(text));
    }

}
