package com.udea.aux_test.config;

import com.udea.aux_test.models.UserEntity;
import com.udea.aux_test.models.ProductEntity;
import com.udea.aux_test.repository.IPurchaseRepository;
import com.udea.aux_test.repository.IUserRepository;
import com.udea.aux_test.repository.IProductRepository;
import com.udea.aux_test.utils.AESUtil;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.crypto.SecretKey;
import java.math.BigDecimal;

@Configuration
public class DatabaseSeeder {

    @Bean
    CommandLineRunner initDatabase(IUserRepository userRepository, IProductRepository productRepository, IPurchaseRepository purchaseRepository) {
        return args -> {
            purchaseRepository.deleteAll();
            userRepository.deleteAll();
            productRepository.deleteAll();

            SecretKey secretKey = AESUtil.generateSecretKey();
            String encryptedPassword = AESUtil.encrypt("admin", secretKey);

            UserEntity adminUser = new UserEntity();
            adminUser.setUsername("admin");
            adminUser.setEmail("admin@gmail.com");
            adminUser.setPassword(encryptedPassword);

            userRepository.save(adminUser);

            ProductEntity product1 = new ProductEntity();
            product1.setProductName("Producto 1");
            product1.setProductPrice(new BigDecimal("10.00"));
            product1.setProductImage("https://letsenhance.io/static/8f5e523ee6b2479e26ecc91b9c25261e/1015f/MainAfter.jpg");

            ProductEntity product2 = new ProductEntity();
            product2.setProductName("Producto 2");
            product2.setProductPrice(new BigDecimal("20.00"));
            product2.setProductImage("https://letsenhance.io/static/03620c83508fc72c6d2b218c7e304ba5/11499/UpscalerAfter.jpg");

            ProductEntity product3 = new ProductEntity();
            product3.setProductName("Producto 3");
            product3.setProductPrice(new BigDecimal("30.00"));
            product3.setProductImage("https://i0.wp.com/picjumbo.com/wp-content/uploads/silhouette-of-young-blonde-with-short-hair-on-orange-background-free-image.jpeg?h=800&quality=80");

            productRepository.save(product1);
            productRepository.save(product2);
            productRepository.save(product3);
        };
    }
}
