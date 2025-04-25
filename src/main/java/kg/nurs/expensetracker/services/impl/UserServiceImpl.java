package kg.nurs.expensetracker.services.impl;

import kg.nurs.expensetracker.mappers.UserMapper;
import kg.nurs.expensetracker.models.User;
import kg.nurs.expensetracker.models.dto.UserCreateDto;
import kg.nurs.expensetracker.models.dto.UserDto;
import kg.nurs.expensetracker.repositories.UserRepo;
import kg.nurs.expensetracker.services.UserService;
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
