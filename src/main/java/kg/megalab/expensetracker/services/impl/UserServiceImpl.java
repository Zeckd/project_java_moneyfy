package kg.megalab.expensetracker.services.impl;

import kg.megalab.expensetracker.mappers.UserMapper;
import kg.megalab.expensetracker.models.User;
import kg.megalab.expensetracker.models.dto.UserCreateDto;
import kg.megalab.expensetracker.models.dto.UserDto;
import kg.megalab.expensetracker.repositories.UserRepo;
import kg.megalab.expensetracker.services.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepo userRepo, UserMapper userMapper) {
        this.userRepo = userRepo;
        this.userMapper = userMapper;
    }

    @Override
    public UserDto create(UserCreateDto userCreateDto) {
        User user = userMapper.UserToUserCreateDto(userCreateDto);
        userRepo.save(user);

        return userMapper.UserToUserDto(user);
    }
}
