package com.example.webcheckitems.cheker;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

@DisplayName("Checking text")
class CheckBracketsTest {

    private final CheckBrackets checkBrackets = new CheckBrackets();

    @Test
    @DisplayName("With opening and closing brackets")
    void check() {
        for (Map.Entry<String, Boolean> entry : StorageText.init().entrySet()) {
            Assertions.assertEquals(checkBrackets.check(entry.getKey()), entry.getValue(), entry.getKey());
        }
    }

}