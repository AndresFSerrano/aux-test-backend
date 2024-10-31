package com.udea.aux_test.repository;

import com.udea.aux_test.models.PurchaseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPurchaseRepository extends JpaRepository<PurchaseEntity, Long> {
    Page<PurchaseEntity> findByUserId(Long userId, Pageable pageable);
    Page<PurchaseEntity> findByProductId(Long productId, Pageable pageable);
}
