package com.MyProject.web.repository;

import com.MyProject.web.Entity.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRequestRepository extends JpaRepository<Purchase,Long> {
}
