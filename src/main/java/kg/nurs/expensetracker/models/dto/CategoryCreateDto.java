package kg.nurs.expensetracker.models.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import kg.megalab.expensetracker.enums.CategoryType;

public record CategoryCreateDto(
        @NotNull
        @NotBlank
        @Size(min = 2, max = 50)
        String name,
        CategoryType type,
        Long userId
) {
}
