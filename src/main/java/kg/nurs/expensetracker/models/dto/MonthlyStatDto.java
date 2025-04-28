package kg.nurs.expensetracker.models.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record MonthlyStatDto(
        @JsonFormat(pattern = "MM.yyyy")
        LocalDate month,
        Double totalIncome,
        Double totalExpense
) {


}
