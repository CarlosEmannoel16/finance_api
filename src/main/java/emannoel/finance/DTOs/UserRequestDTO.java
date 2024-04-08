package emannoel.finance.DTOs;

import jakarta.validation.constraints.NotBlank;

public record UserRequestDTO(
        @NotBlank
        String name,

        @NotBlank
        String email,

        @NotBlank
        String password) {
}
