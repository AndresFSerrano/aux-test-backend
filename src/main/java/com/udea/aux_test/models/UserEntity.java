package com.udea.aux_test.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "USERS")
@Data
public class UserEntity {

    @Id
    @Column(name = "USER_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    @Column(name = "USER_NAME")
    private String userName;

    @Column(name = "USER_EMAIL")
    private String userEmail;

    @Column(name = "USER_PASSWORD")
    private String password;

}
