package com.fd.cache.service;

import com.fd.cache.model.User;
import com.fd.cache.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author fdanismaz
 * date: 9/18/18 10:41 AM
 */
@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User getUser(int id) {
        System.out.println("In service impl...");
        return this.repository.getUser(id);
    }
}
