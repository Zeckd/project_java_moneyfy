package kg.nurs.expensetracker.services;

import kg.nurs.expensetracker.models.dto.UserCreateDto;
import kg.nurs.expensetracker.models.dto.UserDto;

public interface UserService {
    UserDto create(UserCreateDto userCreateDto);
}
