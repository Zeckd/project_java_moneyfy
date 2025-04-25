package kg.megalab.expensetracker.models.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;

public record TransactionCreateDto(
        @Positive
        Double amount,
        String type,
        @NotNull
        CategoryDto category,
        String description,
        @JsonFormat (pattern = "dd.MM.yyyy HH.mm")
        LocalDateTime date
) {
}
