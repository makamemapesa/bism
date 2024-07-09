package com.MyProject.web.dtos;

import com.MyProject.web.Entity.Car;
import com.MyProject.web.Entity.User;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarDto {

    long id;

    String make;

    String CarModel;

    int ProductionYear;

    long price;

    String status;

    String inamge;

    public CarDto(Car car){
        BeanUtils.copyProperties(car,this);
    }

}
