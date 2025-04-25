package kg.megalab.expensetracker.services;

import kg.megalab.expensetracker.models.dto.UserCreateDto;
import kg.megalab.expensetracker.models.dto.UserDto;

public interface UserService {
    UserDto create(UserCreateDto userCreateDto);
}
