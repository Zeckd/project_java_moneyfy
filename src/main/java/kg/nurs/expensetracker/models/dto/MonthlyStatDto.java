package kg.nurs.expensetracker.models.dto;

public record MonthlyStatDto(
        String month,
        Double totalIncome,
        Double totalExpense
) {


}
