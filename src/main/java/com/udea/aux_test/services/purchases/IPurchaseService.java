package com.udea.aux_test.services.purchases;

import com.udea.aux_test.models.PurchaseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IPurchaseService {
    PurchaseEntity createPurchase(Long userId, Long productId, int totalProducts);
    Page<PurchaseEntity> getPurchasesByUserId(Long userId, Pageable pageable);
    Page<PurchaseEntity> getPurchasesByProductId(Long productId, Pageable pageable);
}
