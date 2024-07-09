package com.MyProject.web.dtos;

import com.MyProject.web.Entity.Purchase;
import com.MyProject.web.Entity.Role;
import com.MyProject.web.Entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    Long id;

    String username;

    String password;

    String firstName;

    String middleName;

    String lastName;

    String address ;

    long phoneNumber;

    String status;

    Long roleId;

    public UserDto(User user){
        BeanUtils.copyProperties(user,this);
    }

}
