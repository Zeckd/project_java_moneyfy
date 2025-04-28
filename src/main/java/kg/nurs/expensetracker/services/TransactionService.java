package kg.nurs.expensetracker.services;

import kg.nurs.expensetracker.models.dto.TransactionCreateDto;
import kg.nurs.expensetracker.models.dto.TransactionDto;

import java.util.List;

public interface TransactionService {
    TransactionDto create(TransactionCreateDto transactionCreateDto);

    List <TransactionDto> getAllUserTransactionsById(Long userId);
}
