package com.MyProject.web.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "purchases")
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="purchase_id")
    long id;

    @Column(name="car_id")
    Long carId;

    @Column(name="user_id")
    Long userId;

    @Column(name="Quantity")
     int quantity;

    @Column(name="status")
    String status ;

    @Column(name="created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false,insertable=false, updatable=false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "car_id", nullable = false,insertable=false, updatable=false)
    private Car car;
}
