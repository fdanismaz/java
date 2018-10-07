package com.fd.tryout.security.simple.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.Instant;

/**
 * @author fdanismaz
 * date: 10/7/18 2:07 PM
 */
@Data
@Entity
@Table(name = "USERS")
public class UserEntity extends EntityModel {

    @Column(name = "NAME")
    private String name;

    @Column(name = "SURNAME")
    private String surname;

    @Column(name = "BIRTHDATE")
    private Instant birthdate;

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "EMAIL")
    private String email;

}
