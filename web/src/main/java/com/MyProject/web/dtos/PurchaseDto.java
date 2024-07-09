package com.MyProject.web.dtos;

import com.MyProject.web.Entity.Purchase;
import com.MyProject.web.Entity.User;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseDto {

    long id;

    Long carId;

    Long userId;

    int quantity;

    String status ;

    private LocalDateTime createdAt = LocalDateTime.now();

    public PurchaseDto(Purchase purchase){
        BeanUtils.copyProperties(purchase,this);
    }
}
