package com.MyProject.web.Service;

import com.MyProject.web.Entity.Purchase;
import com.MyProject.web.dtos.PurchaseDto;

import java.util.List;
import java.util.Optional;

public interface PurchaseService {
    List<PurchaseDto> getAllPurchaseRequest();

    void savePurchaseRequest(PurchaseDto purchaseDto);

    void deletePurchaseRequest(Long id);

//   String updatePurchaseRequest(Long id, PurchaseRequest purchaseRequest);

    Optional<PurchaseDto> getPurchaseRequestId(Long id);
}
