package com.MyProject.web.Controler;

import com.MyProject.web.Entity.Role;
import com.MyProject.web.Entity.User;
import com.MyProject.web.Service.RoleService;
import com.MyProject.web.dtos.RoleDto;
import com.MyProject.web.dtos.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("Manager")
@CrossOrigin(origins = "*")
public class RoleController {
    @Autowired
    RoleService managerService;


    @GetMapping()
    public ResponseEntity<List<RoleDto>> getAllManager() {
        List<RoleDto> roles = managerService.getAllManager();
        return new ResponseEntity<>(roles, HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<RoleDto> getManagerId(@PathVariable Long id) {
        Optional<RoleDto> roler = managerService.getManagerId(id);
        return roler.map(RoleDto -> new ResponseEntity<>(RoleDto, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @PostMapping("/save")
    public ResponseEntity<Void> createUser(@RequestBody RoleDto roleDto) {
        managerService.saveManager(roleDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteManager(@PathVariable Long id) {
        managerService.deleteManager(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
//    @PutMapping("/update/{id}")
//    public ResponseEntity<String> updateUser(@PathVariable Long id, @RequestBody RoleDto roleDto) {
//        Optional<RoleDto> existingUser = managerService.getManagerId(id);
//        if (existingUser.isPresent()) {
//            try {
//                Role role = new Role();
//                BeanUtils.copyProperties(roleDto, role);
//                role.setId(id); // Ensure the ID is set for updating
//                managerService.saveManager(roleDto);
//                return new ResponseEntity<>("User updated successfully", HttpStatus.OK);
//            } catch (Exception e) {
//                return new ResponseEntity<>("An error occurred: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//            }
//        } else {
//            return new ResponseEntity<>("User ID does not exist", HttpStatus.NOT_FOUND);
//        }
//    }
}
