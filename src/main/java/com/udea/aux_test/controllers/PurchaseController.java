package com.udea.aux_test.controllers;

import com.udea.aux_test.models.PurchaseEntity;
import com.udea.aux_test.services.purchases.IPurchaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/purchases")
public class PurchaseController {

    private final IPurchaseService purchaseService;

    public PurchaseController(IPurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @PostMapping
    public ResponseEntity<?> createPurchase(
            @RequestParam Long userId,
            @RequestParam Long productId,
            @RequestParam int totalProducts) {
        try {
            PurchaseEntity purchase = purchaseService.createPurchase(userId, productId, totalProducts);
            return ResponseEntity.ok(purchase);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getPurchasesByUserId(
            @PathVariable Long userId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        try {
            Pageable pageable = PageRequest.of(page, size);
            Page<PurchaseEntity> purchases = purchaseService.getPurchasesByUserId(userId, pageable);
            return ResponseEntity.ok(purchases);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<?> getPurchasesByProductId(
            @PathVariable Long productId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        try {
            Pageable pageable = PageRequest.of(page, size);
            Page<PurchaseEntity> purchases = purchaseService.getPurchasesByProductId(productId, pageable);
            return ResponseEntity.ok(purchases);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
