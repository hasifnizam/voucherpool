package org.example.common.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class VoucherRequest {
    private String offerName;
    private String recipientEmail;
    private LocalDate expiredDate;
}
