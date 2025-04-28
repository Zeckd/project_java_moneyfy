package kg.nurs.expensetracker.services;

import kg.nurs.expensetracker.models.dto.MonthlyStatDto;

import java.util.List;

public interface StatService {
    List<MonthlyStatDto> getMonthlyStat(long userId);
}
