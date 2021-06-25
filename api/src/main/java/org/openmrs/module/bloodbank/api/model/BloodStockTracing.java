package org.openmrs.module.bloodbank.api.model;

import org.openmrs.module.bloodbank.api.model.enums.SourceOfBlood;
import org.openmrs.module.bloodbank.api.model.enums.StockStatus;

import javax.persistence.Column;

public class BloodStockTracing extends BaseModel {
	
	private Integer bloodStockTracingId;
	
	private BloodDonor bloodDonor;
	
	private String bloodStorage;
	
	private SourceOfBlood sourceOfBlood;
	
	private String bloodGroup;
	
	private StockStatus stockStatus;
	
	@Column(unique = true)
	private String bloodBagId;
	
	public BloodStockTracing() {
	}
	
	public BloodStockTracing(Integer bloodStockTracingId, BloodDonor bloodDonor, String bloodStorage,
	    SourceOfBlood sourceOfBlood, String bloodGroup, StockStatus stockStatus, String bloodBagId) {
		this.bloodStockTracingId = bloodStockTracingId;
		this.bloodDonor = bloodDonor;
		this.bloodStorage = bloodStorage;
		this.sourceOfBlood = sourceOfBlood;
		this.bloodGroup = bloodGroup;
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
	
	public SourceOfBlood getSourceOfBlood() {
		return sourceOfBlood;
	}
	
	public void setSourceOfBlood(SourceOfBlood sourceOfBlood) {
		this.sourceOfBlood = sourceOfBlood;
	}
	
	public String getBloodGroup() {
		return bloodGroup;
	}
	
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	
	public StockStatus getStockStatus() {
		return stockStatus;
	}
	
	public void setStockStatus(StockStatus stockStatus) {
		this.stockStatus = stockStatus;
	}
	
	public String getBloodBagId() {
		return bloodBagId;
	}
	
	public void setBloodBagId(String bloodBagId) {
		this.bloodBagId = bloodBagId;
	}
}
