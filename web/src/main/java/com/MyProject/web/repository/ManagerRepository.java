package com.MyProject.web.repository;

import com.MyProject.web.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepository extends JpaRepository<Role,Long> {
}
