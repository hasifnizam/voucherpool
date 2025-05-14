package org.example.controller;

import org.example.common.RecipientRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/recipient/v1")
public class RecipientController {

    /** Get all recipient */
    @GetMapping(value = "/list")
    public ResponseEntity<?> recipientList() {
        return null;
    }

    /** Register new recipient */
    @PostMapping(value = "/register")
    public ResponseEntity<?> registerUser(@RequestBody RecipientRequest request) {
        return null;
    }
}
