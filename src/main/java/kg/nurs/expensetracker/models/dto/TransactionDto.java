package kg.nurs.expensetracker.models.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record TransactionDto(
        Long id,
        Double amount,
        String type,
        CategoryDto category,
        String description,
        @JsonFormat(pattern = "dd.MM.yyyy HH.mm")
        LocalDateTime date
) {
}
