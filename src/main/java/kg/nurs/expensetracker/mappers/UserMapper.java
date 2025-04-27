package kg.nurs.expensetracker.mappers;

import kg.nurs.expensetracker.models.User;
import kg.nurs.expensetracker.models.dto.UserCreateDto;
import kg.nurs.expensetracker.models.dto.UserDto;
import kg.nurs.expensetracker.models.dto.UserTransactionDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto UserToUserDto(User user);
    User UserDtoToUser(UserDto userDto);

    UserCreateDto UserToUserCreateDto(User user);
    @Mapping(target = "createdAt", expression = "java(java.time.LocalDateTime.now())")
    User UserToUserCreateDto(UserCreateDto userCreateDto);

    @Mapping(source = "user.id", target = "userId")
    UserTransactionDto UserToUserTransactionDto(User user);
}
