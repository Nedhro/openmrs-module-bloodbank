package org.openmrs.module.bloodbank.api.model;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.search.annotations.Field;
import org.openmrs.module.bloodbank.api.model.enums.Status;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@MappedSuperclass
public class BaseModel implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "uuid", unique = true, nullable = false, length = 38, updatable = false)
	private String uuid = UUID.randomUUID().toString();
	
	@Column(name = "created_by", updatable = false)
	private String createdBy;
	
	@Column(name = "date_created", nullable = false, updatable = false)
	@Field
	private Date dateCreated;
	
	@Column(name = "updated_by")
	private String updatedBy;
	
	@Column(name = "date_changed")
	private Date dateChanged;
	
	@Column(name = "voided", nullable = false)
	@Field
	private Boolean voided;
	
	@Column(name = "status", nullable = false)
	@Field
	private Integer status;
	
	public BaseModel() {
		this.voided = Boolean.FALSE;
		this.status = Status.ACTIVE.getValue();
		this.dateCreated = new Date();
	}
	
	public String getUuid() {
		return this.uuid;
	}
	
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	public String getCreatedBy() {
		return this.createdBy;
	}
	
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	public Date getDateCreated() {
		return this.dateCreated;
	}
	
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	
	public String getUpdatedBy() {
		return this.updatedBy;
	}
	
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	
	public Date getDateChanged() {
		return this.dateChanged;
	}
	
	public void setDateChanged(Date dateChanged) {
		this.dateChanged = dateChanged;
	}
	
	@JsonIgnore
	public Boolean isVoided() {
		return this.getVoided();
	}
	
	public Boolean getVoided() {
		return this.voided;
	}
	
	public void setVoided(Boolean voided) {
		this.voided = voided;
	}
	
	public Integer getStatus() {
		return this.status;
	}
	
	public void setStatus(Integer status) {
		this.status = status;
	}
}
