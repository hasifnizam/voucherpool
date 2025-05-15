package org.example.common.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class OfferRequest {
    @NotBlank(message = "Offer name must not be blank")
    private String name;

    @NotNull(message = "Discount must not be null")
    @Min(value = 1, message = "Discount must be 1 or more")
    private double discount;
}
