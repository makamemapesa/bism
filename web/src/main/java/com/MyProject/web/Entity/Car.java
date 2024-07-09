package com.MyProject.web.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name="Cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cars_id")
    long id;

    @Column(name="make")
    String make;

    @Column(name="model")
    String CarModel;

    @Column(name="production_year")
    int ProductionYear;

    @Column(name="price")
    long price;

    @Column(name="status")
    String status;

    @Column(name="carImage")
    String inamge;

    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL)
    private List<Purchase> purchases;

}
