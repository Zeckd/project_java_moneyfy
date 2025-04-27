package kg.nurs.expensetracker.services;

import jakarta.validation.Valid;
import kg.nurs.expensetracker.models.dto.TransactionCreateDto;
import kg.nurs.expensetracker.models.dto.TransactionDto;
import kg.nurs.expensetracker.models.dto.TransactionUpdateDto;

import java.util.List;

public interface TransactionService {
    TransactionDto create(TransactionCreateDto transactionCreateDto);

    List <TransactionDto> getAllUserTransactionsById(Long userId);

    TransactionDto update(@Valid TransactionUpdateDto transactionUpdateDto, Long transactionId);

    void deleteById(Long transactionId);
}
