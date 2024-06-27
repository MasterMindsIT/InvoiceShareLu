package com.invoice.brands.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Getter
@Setter
public class BrandsErrorResponse {

    private String code;
    private String message;
    private List<String> details;
    private LocalDateTime timestamp;

}
