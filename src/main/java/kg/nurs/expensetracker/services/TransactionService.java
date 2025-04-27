package kg.nurs.expensetracker.services;

import kg.nurs.expensetracker.models.dto.TransactionCreateDto;
import kg.nurs.expensetracker.models.dto.TransactionDto;

public interface TransactionService {
    TransactionDto create(TransactionCreateDto transactionCreateDto);
}
