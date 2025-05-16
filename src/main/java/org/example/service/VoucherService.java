package org.example.service;

import org.example.common.request.VoucherRequest;
import org.example.entity.VoucherEntity;

import java.util.List;

public interface VoucherService {

    List<VoucherEntity> getAllVoucher();
    VoucherEntity generateVoucher(VoucherRequest request);
    VoucherEntity redeemVoucher(String code);
}
