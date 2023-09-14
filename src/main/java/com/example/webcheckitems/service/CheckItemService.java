package com.example.webcheckitems.service;

import com.example.webcheckitems.dto.CheckResponse;
import com.example.webcheckitems.exception.EmptyTextException;
import org.springframework.stereotype.Service;

@Service
public interface CheckItemService {

    CheckResponse checkText(String text) throws EmptyTextException;

}
