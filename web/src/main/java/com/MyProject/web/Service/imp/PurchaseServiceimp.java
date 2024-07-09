package com.MyProject.web.Service.imp;
import com.MyProject.web.Entity.Purchase;
import com.MyProject.web.Entity.Role;
import com.MyProject.web.Entity.User;
import com.MyProject.web.Service.PurchaseService;
import com.MyProject.web.dtos.PurchaseDto;
import com.MyProject.web.dtos.RoleDto;
import com.MyProject.web.dtos.UserDto;
import com.MyProject.web.repository.PurchaseRequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PurchaseServiceimp implements PurchaseService {
    @Autowired
    PurchaseRequestRepository purchaseRequestRepository;


    @Override
    public List<PurchaseDto> getAllPurchaseRequest() {
        return purchaseRequestRepository.findAll().stream()
                .map(PurchaseDto::new)
                .collect(Collectors.toList());
    }


    @Override
    public void savePurchaseRequest(PurchaseDto purchaseDto) {
        Purchase purchase = new Purchase();
        BeanUtils.copyProperties(purchaseDto,purchase);
        purchaseRequestRepository.save(purchase);
    }

    @Override
    public void deletePurchaseRequest(Long id){
        purchaseRequestRepository.deleteById(id);
    }

    @Override
    public Optional<PurchaseDto> getPurchaseRequestId(Long id) {
        Optional<Purchase> purchase = purchaseRequestRepository.findById(id);
        return purchase.map(PurchaseDto::new);
    }
}
