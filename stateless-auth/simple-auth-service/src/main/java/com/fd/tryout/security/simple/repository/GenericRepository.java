package com.fd.tryout.security.simple.repository;

import com.fd.tryout.security.simple.entity.EntityModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author fdanismaz
 * date: 10/7/18 2:06 PM
 */
public interface GenericRepository<T extends EntityModel> extends JpaRepository<T, Integer>, JpaSpecificationExecutor<T> {
}
