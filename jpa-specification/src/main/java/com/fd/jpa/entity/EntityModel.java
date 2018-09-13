package com.fd.jpa.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.UUID;

/**
 * @author furkan.danismaz
 * 10/09/2018 13:32
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
