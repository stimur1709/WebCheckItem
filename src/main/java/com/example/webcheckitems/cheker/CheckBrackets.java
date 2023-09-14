package com.example.webcheckitems.cheker;

import org.springframework.stereotype.Component;

@Component
public class CheckBrackets extends CheckItemImpl {

    protected CheckBrackets() {
        super('(', ')');
    }

}
