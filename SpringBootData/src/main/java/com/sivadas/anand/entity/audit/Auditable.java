package com.sivadas.anand.entity.audit;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Auditable<T> {

	@CreatedBy
	@Column(name = "CREATED_USER", nullable = false, updatable = false)
	protected T createdBy;

	@CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED_DATE", nullable = false, updatable = false)
	protected Timestamp createdDate;

	@LastModifiedBy
	@Column(name = "MODIFIED_USER", nullable = false, updatable = true)
	protected T modifiedBy;

	@LastModifiedDate
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "MODIFIED_DATE", nullable = false, updatable = true)
	protected Timestamp modifiedDate;

	public T getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(final T createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(final Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public T getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(final T modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Timestamp getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(final Timestamp modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

}
