package kg.nurs.expensetracker.controllers;

import jakarta.validation.Valid;
import kg.nurs.expensetracker.models.dto.TransactionCreateDto;
import kg.nurs.expensetracker.models.dto.TransactionDto;
import kg.nurs.expensetracker.services.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/api/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping ("/create")
    public ResponseEntity <?> createTransaction (@Valid @RequestBody TransactionCreateDto transactionCreateDto) {
        TransactionDto savedTransactionDto = transactionService.create (transactionCreateDto);
        return ResponseEntity.created(null).body(savedTransactionDto);
    }

    @GetMapping("/transactions")
    public ResponseEntity<?> getAllUserTransactionsById (@RequestParam Long userId) {
        List <TransactionDto> transactionDtos = transactionService.getAllUserTransactionsById (userId);
        return ResponseEntity.ok(transactionDtos);
    }
}
