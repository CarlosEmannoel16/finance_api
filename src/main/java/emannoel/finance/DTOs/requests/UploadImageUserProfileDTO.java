package emannoel.finance.DTOs.requests;

import jakarta.validation.constraints.NotBlank;
import org.aspectj.weaver.ast.Not;

public record UploadImageUserProfileDTO(
        @NotBlank
        String urlPath,

        @NotBlank
        Long userId
) {
}
