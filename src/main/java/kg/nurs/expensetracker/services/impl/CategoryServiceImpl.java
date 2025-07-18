package kg.nurs.expensetracker.services.impl;

import kg.nurs.expensetracker.mappers.CategoryMapper;
import kg.nurs.expensetracker.models.Category;
import kg.nurs.expensetracker.models.dto.CategoryCreateDto;
import kg.nurs.expensetracker.models.dto.CategoryDto;
import kg.nurs.expensetracker.repositories.CategoryRepo;
import kg.nurs.expensetracker.services.CategoryService;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;
import java.util.List;

@Repository
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepo categoryRepo;
    private final CategoryMapper categoryMapper;

    public CategoryServiceImpl(CategoryRepo categoryRepo, CategoryMapper categoryMapper) {
        this.categoryRepo = categoryRepo;
        this.categoryMapper = categoryMapper;
    }


    @Override
    public List<CategoryDto> findAll() {
        List<Category> categories = categoryRepo.findAll();
        return categoryMapper.CategoryListToCategoryDtoList(categories);
    }

    @Override
    public CategoryDto create(CategoryCreateDto categoryCreateDto) {
        Category category = categoryMapper.CategoryCreateDtoToCategory(categoryCreateDto);
        return categoryMapper.CategoryToCategoryDto(categoryRepo.save(category));
    }

    @Override
    public List<CategoryDto> findAllByUserIsNullAndId(Long userId, int pageNo, int pageSize) {
        Pageable pageable = (Pageable) PageRequest.of(pageNo, pageSize);
        List<Category> categories= categoryRepo.findAllByUserIsNullAndId(userId, pageable);
        return categoryMapper.CategoryListToCategoryDtoList(categories);
    }

    @Override
    public Category findCategoryById(Long categoryId) {
        Category category = categoryRepo.findById(categoryId).orElse(null);
        return category;
    }
}
