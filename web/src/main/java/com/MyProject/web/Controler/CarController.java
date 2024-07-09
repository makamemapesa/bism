package com.MyProject.web.Controler;

import com.MyProject.web.Entity.Car;
import com.MyProject.web.Entity.User;
import com.MyProject.web.Service.CarService;
import com.MyProject.web.dtos.CarDto;
import com.MyProject.web.dtos.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("Cars")
@CrossOrigin(origins = "*")
public class CarController {
    @Autowired
    CarService carService;


    @GetMapping()
    public ResponseEntity<List<CarDto>> getAllCars() {
        List<CarDto> cars = carService.getAllCars();
        return new ResponseEntity<>(cars, HttpStatus.OK);
    }


    @GetMapping("/getById/{id}")
    public ResponseEntity<CarDto> getCarsId(@PathVariable Long id) {
        Optional<CarDto> car = carService.getCarsId(id);
        return car.map(carDto -> new ResponseEntity<>(carDto, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @PostMapping("/save")
    public ResponseEntity<Void> saveCars(@RequestBody CarDto carDto) {
        carService.saveCars(carDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCars(@PathVariable Long id) {
        carService.deleteCars(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


@PutMapping("/update/{id}")
public ResponseEntity<String> updateUser(@PathVariable Long id, @RequestBody CarDto carDto) {
    Optional<CarDto> existingUser = carService.getCarsId(id);
    if (existingUser.isPresent()) {
        try {
            Car car = new Car();
            BeanUtils.copyProperties(carDto, car);
            car.setId(id); // Ensure the ID is set for updating
            carService.saveCars(carDto);
            return new ResponseEntity<>("User updated successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    } else {
        return new ResponseEntity<>("User ID does not exist", HttpStatus.NOT_FOUND);
    }
}






}