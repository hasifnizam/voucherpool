package org.example.controller;

import org.example.common.VoucherRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/voucher/v1")
public class VoucherController {

    /** Get all voucher list */
    @GetMapping(value = "/list")
    public ResponseEntity<?> voucherList() {
        return null;
    }

    /** Generate new voucher */
    @PostMapping(value = "/generate")
    public ResponseEntity<?> newVoucher(@RequestBody VoucherRequest request) {
        return null;
    }

    /** Redeem existing voucher */
    @PostMapping(value = "/redeem/{code}")
    public ResponseEntity<?> newVoucher(@PathVariable String code) {
        return null;
    }
}
