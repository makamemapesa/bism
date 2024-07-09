package com.MyProject.web.Controler;

import com.MyProject.web.Entity.User;
import com.MyProject.web.Service.UsersService;
import com.MyProject.web.dtos.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UsersController {
    @Autowired
    UsersService userService;

    @GetMapping()
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {
        Optional<UserDto> user = userService.getUsersId(id);
        return user.map(userDto -> new ResponseEntity<>(userDto, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @PostMapping("/save")
    public ResponseEntity<Void> createUser(@RequestBody UserDto userDto) {
        userService.saveUsers(userDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }



    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUsers(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Long id, @RequestBody UserDto userDto) {
        Optional<UserDto> existingUser = userService.getUsersId(id);
        if (existingUser.isPresent()) {
            try {
                userService.saveUsers(userDto);
                return new ResponseEntity<>("User updated successfully", HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>("An error occurred: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            return new ResponseEntity<>("User ID does not exist", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("login")
    public ResponseEntity<Optional<User>> login(@RequestBody UserDto userDto){
        Optional<User> user = userService.login(userDto);
        if(user.isEmpty()){
            return new ResponseEntity<>(user, HttpStatus.UNAUTHORIZED);
        }
        else{
            return new ResponseEntity<>(user,HttpStatus.OK);
        }
    }

}
