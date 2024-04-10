package emannoel.finance.DTOs.requests;


import jakarta.validation.constraints.NotBlank;

public record UpdateRequestBankDTO(@NotBlank String name, @NotBlank Long id) {
}
