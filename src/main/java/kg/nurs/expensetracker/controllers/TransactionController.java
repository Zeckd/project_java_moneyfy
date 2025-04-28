package kg.nurs.expensetracker.controllers;

import jakarta.validation.Valid;
import kg.nurs.expensetracker.models.dto.TransactionCreateDto;
import kg.nurs.expensetracker.models.dto.TransactionDto;
import kg.nurs.expensetracker.services.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/api/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping ("/create")
    public ResponseEntity <?> createTransaction (@Valid @RequestBody TransactionCreateDto transactionCreateDto) {
        TransactionDto savedTransactionDto = transactionService.create(transactionCreateDto);
        return ResponseEntity.created(null).body(savedTransactionDto);
    }
}
