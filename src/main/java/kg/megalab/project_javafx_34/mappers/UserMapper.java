package kg.megalab.project_javafx_34.mappers;

import kg.megalab.project_javafx_34.models.User;
import kg.megalab.project_javafx_34.models.dto.UserCreateDto;
import kg.megalab.project_javafx_34.models.dto.UserDto;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {

    User UserCreateDtoToUser(UserCreateDto userCreateDto);

    UserDto UserToUserDto(User user);
    User UserDtoToUser(UserDto userDto);
}
