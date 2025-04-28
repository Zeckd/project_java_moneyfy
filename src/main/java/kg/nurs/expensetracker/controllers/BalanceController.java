package kg.nurs.expensetracker.controllers;

import kg.nurs.expensetracker.models.dto.BalanceUserDto;
import kg.nurs.expensetracker.services.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/api/balance")
public class BalanceController {

    private final TransactionService transactionService;

    public BalanceController(TransactionService transactionService) {
        this.transactionService = transactionService;

    }


    @GetMapping
    public ResponseEntity <?> getBalance(@RequestParam Long userId) {
        BalanceUserDto balanceUserDto = transactionService.getBalance (userId);
        return ResponseEntity.ok().body(balanceUserDto);
    }
}
