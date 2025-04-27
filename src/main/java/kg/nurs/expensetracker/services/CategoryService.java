package kg.nurs.expensetracker.services;

import jakarta.validation.constraints.NotNull;
import kg.nurs.expensetracker.models.Category;
import kg.nurs.expensetracker.models.dto.CategoryCreateDto;
import kg.nurs.expensetracker.models.dto.CategoryDto;

import java.util.List;

public interface CategoryService {
    List<CategoryDto> findAll();

    CategoryDto create(CategoryCreateDto categoryCreateDto);

    List<CategoryDto> findAllByUserIsNullAndId(Long userId, int pageNo, int pageSize);

    Category findCategoryById(@NotNull Long categoryId);
}
