package kg.nurs.expensetracker.controllers;

import kg.nurs.expensetracker.services.StatService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/stats")
public class StatController {

    private final StatService statService;

    public StatController(StatService statService) {
        this.statService = statService;
    }

    @GetMapping ("/monthly/{userId}")
    public ResponseEntity<?> getMonthly(@PathVariable long userId) {
        return ResponseEntity.ok(statService.getMonthlyStat(userId));
    }
}
