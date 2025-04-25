package kg.nurs.expensetracker.models.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CategoryCreateDto(
        @NotNull
        @NotBlank
        @Size(min = 2, max = 50)
        String name,
        String type,
        Long userId
) {
}
