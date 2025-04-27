package kg.nurs.expensetracker.models.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import kg.nurs.expensetracker.models.User;
import kg.nurs.expensetracker.validation.AllowedValues;
import kg.nurs.expensetracker.validation.ExistsEntity;


public record CategoryCreateDto(
        @NotEmpty(message = "Категория не должна быть пустой")
        @NotNull(message = "Категория не должена быть пустой")
        @NotBlank(message = "Категория не должена быть пустой")
        @Size(min = 2, max = 50, message = "Категория должна содержать от 2 до 50 символов")
        String name,
        @AllowedValues(values = {"INCOME", "EXPENSE"}, message = "Тип категории должен быть INCOME или EXPENSE")
        String type,
        //@NotNull
        @ExistsEntity(entityClass = User.class, message = "Пользователь не найден")
        Long userId
) {
}
