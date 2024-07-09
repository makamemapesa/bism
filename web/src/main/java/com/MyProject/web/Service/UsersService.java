package com.MyProject.web.Service;

import com.MyProject.web.Entity.User;
import com.MyProject.web.dtos.UserDto;

import java.util.List;
import java.util.Optional;

public interface UsersService {
    List<UserDto> getAllUsers();

    void saveUsers(UserDto userDto);

    void deleteUsers(Long id);

    Optional<UserDto> getUsersId(Long id);

    Optional<User> login(UserDto userDto);
}
