package com.udea.aux_test.repository;

import com.udea.aux_test.models.ProductEntity;
import com.udea.aux_test.models.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<UserEntity,Long> {
    Page<UserEntity> findAll(Pageable pageable);
}
