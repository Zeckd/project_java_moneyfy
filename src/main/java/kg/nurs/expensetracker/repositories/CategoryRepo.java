package kg.nurs.expensetracker.repositories;

import kg.nurs.expensetracker.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Long> {

    @Query("select u from Category u where  u.user.id is null or u.user.id = ?1")
    List<Category> findAllByUserIsNullAndId(Long id, Pageable pageable);
}
