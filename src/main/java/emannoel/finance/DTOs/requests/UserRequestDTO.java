package emannoel.finance.DTOs.requests;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.context.annotation.Description;
import org.springframework.validation.annotation.Validated;

public record UserRequestDTO(
        @NotBlank(message = "Name is required")
        @NotNull
        @Description("Teste")
        String name,

        @NotBlank(message = "Email is required")
        @Description("Teste")
        String email,

        @NotBlank(message = "Password is required")
        @Description("Teste")
        String password) {
}
