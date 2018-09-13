package com.fd.jpa.repository;

import com.fd.jpa.entity.EntityModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author furkan.danismaz
 * 11/09/2018 14:54
 */
public interface GenericRepository<T extends EntityModel> extends JpaRepository<T, Integer>, JpaSpecificationExecutor<T> {
}
