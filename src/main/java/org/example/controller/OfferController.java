package org.example.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.common.CommonConstant;
import org.example.common.request.OfferRequest;
import org.example.entity.OfferEntity;
import org.example.exception.ServiceException;
import org.example.handler.ResponseHandler;
import org.example.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/offer/v1")
public class OfferController {

    @Autowired
    private OfferService offerService;

    /** Getting all available offer */
    @GetMapping(value = "/list")
    public ResponseEntity<?> getAllOffer() {
        List<OfferEntity> offerList = offerService.getAllOffer();

        //Check if offer list is empty or not
        if (offerList.isEmpty()) {
            return ResponseHandler.generateResponse(HttpStatus.OK, CommonConstant.NO_RECORD, offerList);
        }
        return ResponseHandler.generateResponse(HttpStatus.OK, CommonConstant.SUCCESSFUL, offerList);
    }

    /** Create new offer */
    @PostMapping(value = "/create")
    public ResponseEntity<?> createNewOffer(@Valid @RequestBody OfferRequest request) {
        try {
            OfferEntity offer = offerService.createNewOffer(request);
            return ResponseHandler.generateResponse(HttpStatus.OK, CommonConstant.SUCCESSFUL, offer);
        } catch (ServiceException e) {
            return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, CommonConstant.FAILED, null);
        }
    }
}
