package kg.megalab.expensetracker.mappers;

import kg.megalab.expensetracker.models.User;
import kg.megalab.expensetracker.models.dto.UserCreateDto;
import kg.megalab.expensetracker.models.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto UserToUserDto(User user);
    User UserDtoToUser(UserDto userDto);

    UserCreateDto UserToUserCreateDto(User user);
    @Mapping(target = "createdAt", expression = "java(java.time.LocalDateTime.now())")
    User UserToUserCreateDto(UserCreateDto userCreateDto);
}
