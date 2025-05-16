package org.example.common.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class VoucherRequest {

    @NotBlank(message = "Offer name must not be blank")
    private String offerName;

    @NotBlank(message = "Recipient email must not be blank")
    @Email
    private String recipientEmail;

    @NotNull(message = "Valid days must not be blank")
    @Min(value = 3, message = "Valid days must be more than 3 days")
    private int validDays;
}
