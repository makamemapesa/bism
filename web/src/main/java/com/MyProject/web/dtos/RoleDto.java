package com.MyProject.web.dtos;

import com.MyProject.web.Entity.Car;
import com.MyProject.web.Entity.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class RoleDto {

    Long roleId;

    String roleName;

    public RoleDto(Role role){
        BeanUtils.copyProperties(role,this);
    }
}
