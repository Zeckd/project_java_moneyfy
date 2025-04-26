package kg.megalab.expensetracker.models.dto;

import kg.megalab.expensetracker.enums.CategoryType;

public record CategoryDto(
        Long id,
        String name,
        CategoryType type
) {
}
