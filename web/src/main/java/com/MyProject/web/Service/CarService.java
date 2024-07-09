package com.MyProject.web.Service;

import com.MyProject.web.Entity.Car;
import com.MyProject.web.dtos.CarDto;

import java.util.List;
import java.util.Optional;

public interface CarService {

    List<CarDto> getAllCars();

    void saveCars(CarDto carDto);

    void deleteCars(Long id);

//    String updateCars(Long id, Cars cars);

    Optional<CarDto>getCarsId(Long id);
}
