package com.MyProject.web.Service.imp;

import com.MyProject.web.Entity.User;
import com.MyProject.web.Service.UsersService;
import com.MyProject.web.dtos.UserDto;
import com.MyProject.web.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UsersServiceimp implements UsersService {
    @Autowired
    UserRepository userRepository;

    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(UserDto::new)
                .collect(Collectors.toList());
    }


    @Override
    public void saveUsers(UserDto userDto) {
        User user = new User();
        BeanUtils.copyProperties(userDto,user);
        userRepository.save(user);
    }


    @Override
    public void deleteUsers(Long id) {
        userRepository.deleteById(id);
    }


    @Override
    public Optional<UserDto> getUsersId(Long id) {
        Optional<User> user =userRepository.findById(id);
        return user.map(UserDto::new);
    }

    @Override
    public Optional<User> login(UserDto userDto) {
        return userRepository.findByUsernameAndPassword(userDto.getUsername(),userDto.getPassword());

    }

}
