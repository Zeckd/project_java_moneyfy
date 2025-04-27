package kg.nurs.expensetracker.repositories;

import kg.nurs.expensetracker.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TransactionRepo extends JpaRepository<Transaction, Long> {

    @Query ("select u from Transaction u where u.user.id in ?1")
    List<Transaction> findAllTransactionsById(Long userId);
}
