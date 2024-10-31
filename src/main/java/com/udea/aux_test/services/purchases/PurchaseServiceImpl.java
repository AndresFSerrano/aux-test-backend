package com.udea.aux_test.services.purchases;

import com.udea.aux_test.models.PurchaseEntity;
import com.udea.aux_test.repository.IProductRepository;
import com.udea.aux_test.repository.IPurchaseRepository;
import com.udea.aux_test.repository.IUserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PurchaseServiceImpl implements IPurchaseService {

    private final IPurchaseRepository purchaseRepository;
    private final IUserRepository userRepository;
    private final IProductRepository productRepository;

    public PurchaseServiceImpl(IPurchaseRepository purchaseRepository, IUserRepository userRepository, IProductRepository productRepository) {
        this.purchaseRepository = purchaseRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    @Override
    public PurchaseEntity createPurchase(Long userId, Long productId, int totalProducts) {
        if (!userRepository.existsById(userId)) {
            throw new RuntimeException("User not found with id " + userId);
        }
        if (!productRepository.existsById(productId)) {
            throw new RuntimeException("Product not found with id " + productId);
        }

        PurchaseEntity purchase = new PurchaseEntity();
        purchase.setUserId(userId);
        purchase.setProductId(productId);
        purchase.setTotalProducts(totalProducts);

        return purchaseRepository.save(purchase);
    }

    @Override
    public Page<PurchaseEntity> getPurchasesByUserId(Long userId, Pageable pageable) {
        return purchaseRepository.findByUserId(userId, pageable);
    }

    @Override
    public Page<PurchaseEntity> getPurchasesByProductId(Long productId, Pageable pageable) {
        return purchaseRepository.findByProductId(productId, pageable);
    }
}
