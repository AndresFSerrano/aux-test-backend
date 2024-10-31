package com.udea.aux_test.services.users;

import com.udea.aux_test.models.UserEntity;
import com.udea.aux_test.repository.IUserRepository;
import com.udea.aux_test.utils.AESUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

    private final IUserRepository userRepository;
    private final SecretKey secretKey;

    public UserServiceImpl(IUserRepository userRepository) throws Exception {
        this.userRepository = userRepository;
        this.secretKey = AESUtil.generateSecretKey();
    }

    @Override
    public Page<UserEntity> getUsers(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public Optional<UserEntity> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public UserEntity createUser(UserEntity user) {
        try {
            String encryptedPassword = AESUtil.encrypt(user.getPassword(), secretKey);
            user.setPassword(encryptedPassword);
            return userRepository.save(user);
        } catch (Exception e) {
            throw new RuntimeException("Error encrypting password", e);
        }
    }

    @Override
    public UserEntity updateUser(Long id, UserEntity user) {
        return userRepository.findById(id).map(existingUser -> {
            try {
                existingUser.setUsername(user.getUsername());
                existingUser.setEmail(user.getEmail());
                String encryptedPassword = AESUtil.encrypt(user.getPassword(), secretKey);
                existingUser.setPassword(encryptedPassword);
                return userRepository.save(existingUser);
            } catch (Exception e) {
                throw new RuntimeException("Error encrypting password", e);
            }
        }).orElseThrow(() -> new RuntimeException("User not found with id " + id));
    }

    @Override
    public void deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        } else {
            throw new RuntimeException("User not found with id " + id);
        }
    }
}
