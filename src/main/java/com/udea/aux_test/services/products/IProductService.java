package com.udea.aux_test.services.products;

import com.udea.aux_test.models.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IProductService {
    Page<ProductEntity> getProducts(Pageable pageable);
    Optional<ProductEntity> getProductById(Long id);
    ProductEntity createProduct(ProductEntity product);
    ProductEntity updateProduct(Long id, ProductEntity product);
    void deleteProduct(Long id);
}
