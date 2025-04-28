package kg.nurs.expensetracker.services.impl;

import kg.nurs.expensetracker.mappers.TransactionMapper;
import kg.nurs.expensetracker.models.Category;
import kg.nurs.expensetracker.models.Transaction;
import kg.nurs.expensetracker.models.User;
import kg.nurs.expensetracker.models.dto.TransactionCreateDto;
import kg.nurs.expensetracker.models.dto.TransactionDto;
import kg.nurs.expensetracker.repositories.TransactionRepo;
import kg.nurs.expensetracker.services.CategoryService;
import kg.nurs.expensetracker.services.TransactionService;
import kg.nurs.expensetracker.services.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {



    private final TransactionRepo transactionRepo;
    private final CategoryService categoryService;
    private final UserService userService;


    public TransactionServiceImpl(TransactionRepo transactionRepo, CategoryService categoryService, UserService userService) {
        this.transactionRepo = transactionRepo;
        this.categoryService = categoryService;
        this.userService = userService;
    }

    @Override
    public TransactionDto create(TransactionCreateDto transactionCreateDto) {
        Category category = categoryService.findCategoryById (transactionCreateDto.categoryId());
        User user = userService.findUserById (transactionCreateDto.userId());
        Transaction transaction = TransactionMapper.INSTANCE.transactionCreateDtoToTransaction(transactionCreateDto);
        transaction.setCategory(category);
        transaction.setUser(user);
        transaction = transactionRepo.save(transaction);
        return TransactionMapper.INSTANCE.transactionToTransactionDto(transaction);
    }

    @Override
    public List<TransactionDto> getAllUserTransactionsById(Long userId) {
        List <Transaction> transactions = transactionRepo.findAllTransactionsById(userId);
        List<TransactionDto> transactionDtos = TransactionMapper.INSTANCE.transactionToTransactionDtoList(transactions);
        return transactionDtos;
    }
}
