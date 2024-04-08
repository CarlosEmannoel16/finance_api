package emannoel.finance.DTOs;


import jakarta.validation.constraints.NotBlank;

public record UpdateRequestBankDTO(@NotBlank String name, @NotBlank Long id) {
}
