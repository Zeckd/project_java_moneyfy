package kg.nurs.expensetracker.models.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;

public record TransactionCreateDto(
        Long userId,
        @Positive
        Double amount,
        String type,
        @NotNull
        Long categoryId,
        String description,
        @JsonFormat (pattern = "dd.MM.yyyy HH.mm")
        LocalDateTime date
) {
}
