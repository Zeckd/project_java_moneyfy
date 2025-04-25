package kg.nurs.expensetracker.mappers;

import kg.nurs.expensetracker.models.Category;
import kg.nurs.expensetracker.models.dto.CategoryCreateDto;
import kg.nurs.expensetracker.models.dto.CategoryDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryDto CategoryToCategoryDto(Category category);
    Category CategoryDtoToCategory(CategoryDto categoryDto);

    List<CategoryDto> CategoryListToCategoryDtoList(List<Category> categoryList);
    List<Category> CategoryDtoListToCategoryList(List<CategoryDto> categoryDtoList);

    @Mapping(target = "user.id", source = "userId")
    Category CategoryCreateDtoToCategory(CategoryCreateDto categoryCreateDto);
    CategoryCreateDto CategoryToCategoryCreateDto(Category category);
}
