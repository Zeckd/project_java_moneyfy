package kg.nurs.expensetracker.services.impl;

import kg.nurs.expensetracker.models.dto.MonthlyStatDto;
import kg.nurs.expensetracker.repositories.StatRepo;
import kg.nurs.expensetracker.services.StatService;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class StatServiceImpl implements StatService {

    private final StatRepo statRepo;

    public StatServiceImpl(StatRepo statRepo) {
        this.statRepo = statRepo;
    }

    @Override
    public List<MonthlyStatDto> getMonthlyStat(long userId) {
        List<Object[]> results = statRepo.getStatByUserId(userId);

        return results.stream().map(obj -> {
            Timestamp timestamp =(Timestamp)  obj[0];
            LocalDate month = timestamp.toLocalDateTime().toLocalDate();
            Double totalIncome = ((Number) obj[1]).doubleValue();
            Double totalExpense = ((Number) obj[2]).doubleValue();

            return new MonthlyStatDto(month, totalIncome, totalExpense);
        }).toList();
    }
}
