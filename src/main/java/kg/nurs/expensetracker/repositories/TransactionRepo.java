package kg.nurs.expensetracker.repositories;

import kg.nurs.expensetracker.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepo extends JpaRepository<Transaction, Long> {
}
