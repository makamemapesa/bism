package com.MyProject.web.Service.imp;

import com.MyProject.web.Entity.Car;
import com.MyProject.web.Entity.User;
import com.MyProject.web.Service.CarService;
import com.MyProject.web.dtos.CarDto;
import com.MyProject.web.dtos.UserDto;
import com.MyProject.web.repository.CarsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarServicesimp implements CarService {

    @Autowired
    CarsRepository carsRepository;


    @Override
    public List<CarDto> getAllCars() {
        return carsRepository.findAll().stream()
                .map(CarDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public void saveCars(CarDto carDto) {
        Car car = new Car();
        BeanUtils.copyProperties(carDto,car);
        carsRepository.save(car);
    }


    @Override
    public void deleteCars(Long id){
        carsRepository.deleteById(id);
    }



    @Override
    public Optional<CarDto> getCarsId(Long id) {
        Optional<Car> car = carsRepository.findById(id);
        return car.map(CarDto::new);
    }


}
