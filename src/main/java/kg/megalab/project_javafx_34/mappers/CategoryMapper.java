package kg.megalab.project_javafx_34.mappers;

import kg.megalab.project_javafx_34.models.Category;
import kg.megalab.project_javafx_34.models.dto.CategoryCreateDto;
import kg.megalab.project_javafx_34.models.dto.CategoryDto;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    @Mapping(target = "user.id", source = "userId")
    Category CategoryCreateDtoToCategory(CategoryCreateDto categoryCreateDto);

    CategoryDto CategoryToCategoryDto(Category category, @Context UserMapper userMapper);
    Category CategoryDtoToCategory(CategoryDto categoryDto, @Context UserMapper userMapper);
}
