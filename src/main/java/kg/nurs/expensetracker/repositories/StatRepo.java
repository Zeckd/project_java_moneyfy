package kg.nurs.expensetracker.repositories;

import kg.nurs.expensetracker.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatRepo extends JpaRepository<Transaction, Long> {


    @Query(value = "SELECT " +
            "  DATE_TRUNC('month', u.date) AS month, " +
            "  SUM(CASE WHEN u.type = 'INCOME' THEN u.amount ELSE 0 END) AS total_income, " +
            "  SUM(CASE WHEN u.type = 'EXPENSE' THEN u.amount ELSE 0 END) AS total_expense " +
            "FROM " +
            "  transactions u " +
            "WHERE u.user_id = ?1 " +
            "GROUP BY " +
            "  month " +
            "ORDER BY " +
            "  month",
            nativeQuery = true)
    List<Object[]> getStatByUserId(long userId);
}
