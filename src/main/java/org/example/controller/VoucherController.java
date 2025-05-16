package org.example.controller;

import jakarta.validation.Valid;
import org.example.common.CommonConstant;
import org.example.common.request.VoucherRequest;
import org.example.entity.VoucherEntity;
import org.example.exception.ServiceException;
import org.example.handler.ResponseHandler;
import org.example.service.VoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/voucher/v1")
public class VoucherController {

    @Autowired
    private VoucherService voucherService;

    /** Get all voucher list */
    @GetMapping(value = "/list")
    public ResponseEntity<?> getAllVoucher() {
        List<VoucherEntity> voucherList = voucherService.getAllVoucher();

        //Check if voucher list is empty or not
        if (voucherList.isEmpty()) {
            return ResponseHandler.generateResponse(HttpStatus.OK, CommonConstant.NO_RECORD, voucherList);
        }
        return ResponseHandler.generateResponse(HttpStatus.OK, CommonConstant.SUCCESSFUL, voucherList);
    }

    /** Generate new voucher */
    @PostMapping(value = "/generate")
    public ResponseEntity<?> generateVoucher(@Valid @RequestBody VoucherRequest request) {
        try {
            VoucherEntity voucher = voucherService.generateVoucher(request);
            return ResponseHandler.generateResponse(HttpStatus.OK, CommonConstant.SUCCESSFUL, voucher);
        } catch (ServiceException e) {
            return ResponseHandler.generateResponse(e.getStatus(), e.getMessage(), null);
        }
    }

    /** Redeem existing voucher */
    @PostMapping(value = "/redeem/{code}")
    public ResponseEntity<?> redeemVoucher(@PathVariable String code) {
        try {
            VoucherEntity voucher = voucherService.redeemVoucher(code);
            return ResponseHandler.generateResponse(HttpStatus.OK, CommonConstant.SUCCESSFUL, voucher);
        } catch (ServiceException e) {
            return ResponseHandler.generateResponse(e.getStatus(), e.getMessage(), null);
        }
    }
}
