package org.example.controller;

import org.example.common.OfferRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/offer/v1")
public class OfferController {

    /** Getting all available offer */
    @GetMapping(value = "/list")
    public ResponseEntity<?> offerList() {
        return null;
    }

    /** Create new offer */
    @PostMapping(value = "/create")
    public ResponseEntity<?> newOffer(@RequestBody OfferRequest request) {
        return null;
    }
}
