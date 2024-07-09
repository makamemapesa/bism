package com.MyProject.web.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name="roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="role_id")
    Long roleId;

    @Column(name="role_name")
    String roleName;

    @OneToMany(mappedBy = "role")
    @JsonIgnore
    private List<User> users;
}
