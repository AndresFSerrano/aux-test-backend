package com.udea.aux_test.services.users;

import com.udea.aux_test.models.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IUserService {
    Page<UserEntity> getUsers(Pageable pageable);
    Optional<UserEntity> getUserById(Long id);
    UserEntity createUser(UserEntity user);
    UserEntity updateUser(Long id, UserEntity user);
    void deleteUser(Long id);
}
