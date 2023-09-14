package com.example.webcheckitems.service;

import com.example.webcheckitems.cheker.CheckBrackets;
import org.springframework.stereotype.Service;

@Service
public class CheckBracketService extends CheckItemServiceImpl<CheckBrackets> {

    public CheckBracketService(CheckBrackets checker) {
        super(checker);
    }

}
