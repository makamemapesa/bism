package com.MyProject.web.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    Long id;

    @Column(name="username")
    String username;

    @Column(name="password")
    String password;

    @Column(name="first_name")
    String firstName;

    @Column(name="middle_name")
    String middleName;

    @Column(name="last_name")
    String lastName;

    @Column(name="address")
    String address ;

    @Column(name="phone_number")
    long phoneNumber;

    @Column(name="email")
    String status;

    @Column(name="role_id", nullable = false)
    Long roleId;

    @ManyToOne
    @JoinColumn(name = "role_id",insertable=false, updatable=false)
    private Role role;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Purchase> purchases;


}
