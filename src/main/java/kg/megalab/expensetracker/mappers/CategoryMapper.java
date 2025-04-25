package kg.megalab.expensetracker.mappers;

import kg.megalab.expensetracker.models.Category;
import kg.megalab.expensetracker.models.dto.CategoryCreateDto;
import kg.megalab.expensetracker.models.dto.CategoryDto;
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
