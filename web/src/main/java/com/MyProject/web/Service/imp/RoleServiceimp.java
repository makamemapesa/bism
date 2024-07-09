package com.MyProject.web.Service.imp;

import com.MyProject.web.Entity.Role;
import com.MyProject.web.Entity.User;
import com.MyProject.web.Service.RoleService;
import com.MyProject.web.dtos.RoleDto;
import com.MyProject.web.dtos.UserDto;
import com.MyProject.web.repository.ManagerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoleServiceimp implements RoleService {

    @Autowired
    ManagerRepository managerRepository ;

    @Override
    public List<RoleDto> getAllManager(){
        return managerRepository.findAll().stream()
                .map(RoleDto::new)
                .collect(Collectors.toList());
    }


    @Override
    public void saveManager(RoleDto roleDto) {
        Role role = new Role();
        BeanUtils.copyProperties(roleDto,role);
        managerRepository.save(role);
    }

    @Override
    public void deleteManager(Long id){
        managerRepository.deleteById(id);
    }


    @Override
    public Optional<RoleDto> getManagerId(Long id) {
        Optional<Role> role =managerRepository.findById(id);
        return role.map(RoleDto::new);
    }

}
