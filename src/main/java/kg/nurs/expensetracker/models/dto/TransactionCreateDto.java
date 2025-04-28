package kg.nurs.expensetracker.models.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import kg.nurs.expensetracker.models.Category;
import kg.nurs.expensetracker.models.User;
import kg.nurs.expensetracker.validation.AllowedValues;
import kg.nurs.expensetracker.validation.ExistsEntity;

import java.time.LocalDateTime;

public record TransactionCreateDto(
        @Positive
        Double amount,
        @ExistsEntity(entityClass = User.class, message = "Пользователь не существует")
        Long userId,
        @AllowedValues(values = {"EXPENSE", "INCOME"}, message = "поле должен быть expense или income")
        String type,
        @NotNull
        @ExistsEntity(entityClass = Category.class, message = "Категория не существует")
        Long categoryId,
        String description,
        @JsonFormat (pattern = "dd.MM.yyyy HH:mm")
        LocalDateTime date
) {
}
