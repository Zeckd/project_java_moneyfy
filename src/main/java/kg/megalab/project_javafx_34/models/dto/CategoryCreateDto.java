package kg.megalab.project_javafx_34.models.dto;

import jakarta.validation.constraints.*;
import kg.megalab.project_javafx_34.models.User;
import kg.megalab.project_javafx_34.validation.AllowedValues;
import kg.megalab.project_javafx_34.validation.ExistsEntity;

public record CategoryCreateDto(
        @NotEmpty(message = "Категория не должна быть пустой")
        @NotNull(message = "Категория не должена быть пустой")
        @NotBlank(message = "Категория не должена быть пустой")
        @Size(min = 2, max = 50, message = "Категория должна содержать от 2 до 50 символов")
        String name,
        @AllowedValues(values = {"INCOME", "EXPENSE"}, message = "Тип категории должен быть INCOME или EXPENSE")
        String type,
        @NotNull
        @ExistsEntity(entityClass = User.class, message = "Пользователь не найден")
        Long userId
) {
}
