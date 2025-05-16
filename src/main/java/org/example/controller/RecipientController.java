package org.example.controller;

import jakarta.validation.Valid;
import org.example.common.CommonConstant;
import org.example.common.request.RecipientRequest;
import org.example.entity.RecipientEntity;
import org.example.exception.ServiceException;
import org.example.handler.ResponseHandler;
import org.example.service.RecipientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/recipient/v1")
public class RecipientController {

    @Autowired
    private RecipientService recipientService;

    /** Get all recipient */
    @GetMapping(value = "/list")
    public ResponseEntity<?> getAllRecipient() {
        List<RecipientEntity> recipientList = recipientService.getAllRecipient();

        if (recipientList.isEmpty()) {
            return ResponseHandler.generateResponse(HttpStatus.OK, CommonConstant.NO_RECORD, recipientList);
        }
        return ResponseHandler.generateResponse(HttpStatus.OK, CommonConstant.SUCCESSFUL, recipientList);
    }

    /** Register new recipient */
    @PostMapping(value = "/register")
    public ResponseEntity<?> registerNewUser(@Valid @RequestBody RecipientRequest request) {
        try {
            RecipientEntity recipient = recipientService.registerNewUser(request);
            return ResponseHandler.generateResponse(HttpStatus.OK, CommonConstant.SUCCESSFUL, recipient);
        } catch (ServiceException e) {
            return ResponseHandler.generateResponse(e.getStatus(), e.getMessage(), null);
        }
    }
}
