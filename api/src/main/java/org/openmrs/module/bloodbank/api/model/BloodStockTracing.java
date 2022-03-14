package org.openmrs.module.bloodbank.api.model;

import javax.persistence.Column;
import javax.persistence.ManyToOne;

public class BloodStockTracing extends BaseModel {
	
	private Integer bloodStockTracingId;
	
	@ManyToOne
	private BloodDonor bloodDonor;
	
	private String bloodStorage;
	
	private String bloodComponent;
	
	private String sourceOfBlood;
	
	private String bloodGroup;
	
	private String bloodGroupRhesus;
	
	private String stockStatus;
	
	@Column(unique = true)
	private String bloodBagId;
	
	public BloodStockTracing() {
	}
	
	public BloodStockTracing(Integer bloodStockTracingId, BloodDonor bloodDonor, String bloodStorage, String bloodComponent,
	    String sourceOfBlood, String bloodGroup, String bloodGroupRhesus, String stockStatus, String bloodBagId) {
		this.bloodStockTracingId = bloodStockTracingId;
		this.bloodDonor = bloodDonor;
		this.bloodStorage = bloodStorage;
		this.bloodComponent = bloodComponent;
		this.sourceOfBlood = sourceOfBlood;
		this.bloodGroup = bloodGroup;
		this.bloodGroupRhesus = bloodGroupRhesus;
		this.stockStatus = stockStatus;
		this.bloodBagId = bloodBagId;
	}
	
	public Integer getBloodStockTracingId() {
		return bloodStockTracingId;
	}
	
	public void setBloodStockTracingId(Integer bloodStockTracingId) {
		this.bloodStockTracingId = bloodStockTracingId;
	}
	
	public BloodDonor getBloodDonor() {
		return bloodDonor;
	}
	
	public void setBloodDonor(BloodDonor bloodDonor) {
		this.bloodDonor = bloodDonor;
	}
	
	public String getBloodStorage() {
		return bloodStorage;
	}
	
	public void setBloodStorage(String bloodStorage) {
		this.bloodStorage = bloodStorage;
	}
	
	public String getBloodComponent() {
		return bloodComponent;
	}
	
	public void setBloodComponent(String bloodComponent) {
		this.bloodComponent = bloodComponent;
	}
	
	public String getSourceOfBlood() {
		return sourceOfBlood;
	}
	
	public void setSourceOfBlood(String sourceOfBlood) {
		this.sourceOfBlood = sourceOfBlood;
	}
	
	public String getBloodGroup() {
		return bloodGroup;
	}
	
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	
	public String getBloodGroupRhesus() {
		return bloodGroupRhesus;
	}
	
	public void setBloodGroupRhesus(String bloodGroupRhesus) {
		this.bloodGroupRhesus = bloodGroupRhesus;
	}
	
	public String getStockStatus() {
		return stockStatus;
	}
	
	public void setStockStatus(String stockStatus) {
		this.stockStatus = stockStatus;
	}
	
	public String getBloodBagId() {
		return bloodBagId;
	}
	
	public void setBloodBagId(String bloodBagId) {
		this.bloodBagId = bloodBagId;
	}
}
