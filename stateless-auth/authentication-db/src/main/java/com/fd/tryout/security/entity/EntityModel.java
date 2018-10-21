package com.fd.tryout.security.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author fdanismaz
 * date: 10/7/18 2:07 PM
 */
@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class EntityModel implements Serializable {

    @Id
    @Column(name = "DB_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected int id;

    @Column(name = "DELETED", nullable = false)
    protected boolean deleted;

    @CreatedBy
    @Column(name = "CREATED_BY")
    protected String createdBy;

    @CreatedDate
    @Column(name = "CREATED_DATE", nullable = false, updatable = false)
    protected long createdDate;

    @LastModifiedDate
    @Column(name = "LAST_MODIFIED_DATE", nullable =  false)
    protected long lastModifiedDate;

    @LastModifiedBy
    @Column(name = "LAST_MODIFIED_BY")
    protected String lastModifiedBy;

}
