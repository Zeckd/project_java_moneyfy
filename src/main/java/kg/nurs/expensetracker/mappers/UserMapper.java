package kg.nurs.expensetracker.mappers;

import kg.nurs.expensetracker.models.User;
import kg.nurs.expensetracker.models.dto.UserCreateDto;
import kg.nurs.expensetracker.models.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto UserToUserDto(User user);
    User UserDtoToUser(UserDto userDto);

    @Mapping(target = "createdAt", expression = "java(java.time.LocalDateTime.now())")
    User UserCreateDtoToUser(UserCreateDto userCreateDto);

    List<UserDto> UserListToUserDtoList(List<User> userList);


}
