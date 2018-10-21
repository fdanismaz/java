package com.fd.tryout.security;

import com.fd.tryout.security.entity.UserEntity;
import com.fd.tryout.security.repository.user.UserRepository;
import com.fd.tryout.security.repository.user.UserSpecifications;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import java.util.ArrayList;
import java.util.Optional;

/**
 * @author fdanismaz
 * date: 10/7/18 1:18 PM
 */
@Slf4j
public class DbAuthenticationProvider implements AuthenticationProvider {

    private UserRepository userRepository;

    public DbAuthenticationProvider(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        if (this.validateCredentials(username, password)) {
            return new UsernamePasswordAuthenticationToken(username, password, new ArrayList<>());
        }

        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

    private boolean validateCredentials(String username, String password) {
        Optional<UserEntity> user = this.userRepository.findOne(UserSpecifications.withUsernameAndPassword(username, password));
        if (user.isPresent()) {
            return true;
        }
        return false;
    }
}
