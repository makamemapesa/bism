package com.MyProject.web.Controler;

import com.MyProject.web.Entity.Car;
import com.MyProject.web.Entity.Purchase;
import com.MyProject.web.Service.PurchaseService;
import com.MyProject.web.dtos.CarDto;
import com.MyProject.web.dtos.PurchaseDto;
import com.MyProject.web.dtos.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("PurchaseRequst")
@CrossOrigin("*")
public class PurchaseController {
    PurchaseService purchaseRequestService;



    @GetMapping()
    public ResponseEntity<List<PurchaseDto>> getAllPurchaseRequest() {
        List<PurchaseDto> purchases = purchaseRequestService.getAllPurchaseRequest();
        return new ResponseEntity<>(purchases, HttpStatus.OK);
    }



    @GetMapping("/getById/{id}")
    public ResponseEntity<PurchaseDto> getPurchaseRequestId(@PathVariable Long id) {
        Optional<PurchaseDto> purchaser = purchaseRequestService.getPurchaseRequestId(id);
        return purchaser.map(userDto -> new ResponseEntity<>(userDto, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @PostMapping("/save")
    public ResponseEntity<Void> createUser(@RequestBody PurchaseDto purchaseDto) {
        purchaseRequestService.savePurchaseRequest(purchaseDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }



    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePurchase(@PathVariable Long id) {
        purchaseRequestService.deletePurchaseRequest(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Long id, @RequestBody PurchaseDto purchaseDto) {
        Optional<PurchaseDto> existingUser = purchaseRequestService.getPurchaseRequestId(id);
        if (existingUser.isPresent()) {
            try {
                Purchase purchase = new Purchase();
                BeanUtils.copyProperties(purchaseDto, purchase);
                purchase.setId(id); // Ensure the ID is set for updating
                purchaseRequestService.savePurchaseRequest(purchaseDto);
                return new ResponseEntity<>("User updated successfully", HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>("An error occurred: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            return new ResponseEntity<>("User ID does not exist", HttpStatus.NOT_FOUND);
        }
    }
}
