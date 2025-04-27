package kg.megalab.project_javafx_34.repositories;

import kg.megalab.project_javafx_34.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepo extends JpaRepository<Transaction, Long> {
}
