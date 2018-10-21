package com.fd.tryout.security.repository.user;

import com.fd.tryout.security.entity.UserEntity;
import com.fd.tryout.security.entity.UserEntity_;
import org.springframework.data.jpa.domain.Specification;

/**
 * @author fdanismaz
 * date: 10/7/18 2:12 PM
 */
public class UserSpecifications {

    public static Specification<UserEntity> withUsernameAndPassword(String username, String password) {
        return (Specification<UserEntity>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.and(
                criteriaBuilder.equal(root.get(UserEntity_.username), username),
                criteriaBuilder.equal(root.get(UserEntity_.password), password));
    }
}
