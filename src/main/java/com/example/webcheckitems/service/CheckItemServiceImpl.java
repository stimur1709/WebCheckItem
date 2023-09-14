package com.example.webcheckitems.service;

import com.example.webcheckitems.cheker.CheckItemImpl;
import com.example.webcheckitems.dto.CheckResponse;
import com.example.webcheckitems.exception.EmptyTextException;
import lombok.AllArgsConstructor;


@AllArgsConstructor
public abstract class CheckItemServiceImpl<C extends CheckItemImpl> implements CheckItemService {

    private final C checker;

    @Override
    public CheckResponse checkText(String text) {
        return new CheckResponse(checker.check(text));
    }

}
