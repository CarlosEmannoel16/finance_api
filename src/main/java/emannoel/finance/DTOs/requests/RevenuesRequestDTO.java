package emannoel.finance.DTOs.requests;

import jakarta.validation.constraints.NotBlank;

import java.util.Date;

public record RevenuesRequestDTO(
        @NotBlank Long idBank,
        @NotBlank Double amount,
        @NotBlank String description,
        @NotBlank Date dateOfRevenue
    ) {
}
