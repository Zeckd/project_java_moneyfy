package kg.nurs.expensetracker.repositories;

import kg.nurs.expensetracker.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TransactionRepo extends JpaRepository<Transaction, Long> {

    @Query ("select u from Transaction u where u.user.id in ?1")
    List<Transaction> findAllTransactionsById(Long userId);

    @Query("SELECT COALESCE(SUM(u.amount), 0) FROM Transaction u WHERE LOWER(u.type) = 'income' AND u.user.id = ?1")
    Double findAllIncomeTransactionsById(Long userId);

    @Query("SELECT COALESCE(SUM(u.amount), 0) FROM Transaction u WHERE LOWER(u.type) = 'expense' AND u.user.id = ?1")
    Double findAllExpenseTransactionsById(Long userId);
}
