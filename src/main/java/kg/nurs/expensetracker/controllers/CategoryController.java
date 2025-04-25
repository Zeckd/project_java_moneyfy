package kg.nurs.expensetracker.controllers;

import jakarta.validation.Valid;
import kg.nurs.expensetracker.models.dto.CategoryCreateDto;
import kg.nurs.expensetracker.models.dto.CategoryDto;
import kg.nurs.expensetracker.services.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/all/{userId}")
    public ResponseEntity<?> findAllByUserIsNullAndId(@PathVariable Long userId, @RequestParam int pageNo, @RequestParam int pageSize) {
        List<CategoryDto> categories= categoryService.findAllByUserIsNullAndId(userId, pageNo, pageSize);
        return ResponseEntity.ok(categories);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@Valid @RequestBody CategoryCreateDto categoryCreateDto) {
        CategoryDto categoryDto = categoryService.create(categoryCreateDto);
        return ResponseEntity.created(null).body(categoryDto);
    }
}
