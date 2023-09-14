package com.example.webcheckitems.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TextRequest(@NotNull @NotBlank String text) {

}
