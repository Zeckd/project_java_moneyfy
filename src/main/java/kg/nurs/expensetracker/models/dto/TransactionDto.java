package kg.nurs.expensetracker.models.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import kg.nurs.expensetracker.models.Category;
import kg.nurs.expensetracker.models.User;

import java.time.LocalDateTime;

public record TransactionDto(
        Long id,
        UserTransactionDto userId,
        Double amount,
        String type,
        CategoryDto categoryDto,
        String description,
        @JsonFormat(pattern = "dd.MM.yyyy HH.mm")
        LocalDateTime date
) {
}
