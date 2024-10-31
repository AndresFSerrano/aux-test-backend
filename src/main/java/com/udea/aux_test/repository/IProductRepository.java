package com.udea.aux_test.repository;

import com.udea.aux_test.models.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends JpaRepository<ProductEntity,Long> {
    Page<ProductEntity> findAll(Pageable pageable);
}
