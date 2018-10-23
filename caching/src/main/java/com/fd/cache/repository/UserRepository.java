package com.fd.cache.repository;

import com.fd.cache.model.User;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 * @author fdanismaz
 * date: 9/18/18 10:42 AM
 */
@Component
public class UserRepository {

    @Cacheable(value = "db-users", key = "#id")
    public User getUser(int id) {
        if (id == 1) {
            System.out.println("Reading john doe from repository...");
            return User.builder().id(1).name("john").surname("doe").build();
        } else if (id == 2) {
            System.out.println("Reading jane doe from repository...");
            return User.builder().id(2).name("jane").surname("doe").build();
        }
        return null;
    }

}
