package kg.nurs.expensetracker.repositories;

import kg.nurs.expensetracker.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatRepo extends JpaRepository<Transaction, Long> {


    @Query(value = "SELECT " +
            "  TO_CHAR(u.date, 'MM.YYYY') AS month, " +
            "  SUM(CASE WHEN u.type = 'INCOME' THEN u.amount ELSE 0 END) AS total_income, " +
            "  SUM(CASE WHEN u.type = 'EXPENSE' THEN u.amount ELSE 0 END) AS total_expense " +
            "FROM " +
            "  transactions u " +  // <-- здесь именно название таблицы в БД
            "WHERE u.user_id = ?1 " +
            "GROUP BY " +
            "  month " +
            "ORDER BY " +
            "  month",
            nativeQuery = true)  // <-- ОБЯЗАТЕЛЬНО
    List<Object[]> getStatByUserId(long userId);
}
