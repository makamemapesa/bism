package com.MyProject.web.Service;

import com.MyProject.web.Entity.Role;
import com.MyProject.web.dtos.RoleDto;

import java.util.List;
import java.util.Optional;

public interface RoleService {
    List<RoleDto> getAllManager();

    void saveManager(RoleDto roleDto);

    void deleteManager(Long id);

//   String updateManager(Long id, Manager manager);

    Optional<RoleDto> getManagerId(Long id);
}
