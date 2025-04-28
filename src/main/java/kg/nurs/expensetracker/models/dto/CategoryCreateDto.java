package kg.nurs.expensetracker.models.dto;

import jakarta.validation.constraints.*;
import kg.nurs.expensetracker.models.Category;
import kg.nurs.expensetracker.models.User;
import kg.nurs.expensetracker.validation.AllowedValues;
import kg.nurs.expensetracker.validation.ExistsEntity;
import kg.nurs.expensetracker.validation.UniqueField;


public record CategoryCreateDto(
        @NotEmpty(message = "Категория не должна быть пустой")
        @NotNull(message = "Категория не должена быть пустой")
        @NotBlank(message = "Категория не должена быть пустой")
        @Size(min = 2, max = 50, message = "Категория должна содержать от 2 до 50 символов")
        @UniqueField(fieldName = "name", entityClass = Category.class, message = "Такая категория уже существует")
        String name,
        @AllowedValues(values = {"INCOME", "EXPENSE"}, message = "Тип категории должен быть INCOME или EXPENSE")
        String type,
        @ExistsEntity(entityClass = User.class, message = "пользователь не существует")
        Long userId
) {
}
