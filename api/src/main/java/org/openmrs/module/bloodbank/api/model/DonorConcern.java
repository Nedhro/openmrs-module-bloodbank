package org.openmrs.module.bloodbank.api.model;

import java.io.Serializable;

public class DonorConcern implements Serializable {
	
	private Integer donorConcernId;
	
	private String concernName;
	
	private Gender concernFor;
	
	private ConcernStatus concernStatus;
	
	private BloodDonor bloodDonor;
	
	public Integer getDonorConcernId() {
		return donorConcernId;
	}
	
	public void setDonorConcernId(Integer donorConcernId) {
		this.donorConcernId = donorConcernId;
	}
	
	public String getConcernName() {
		return concernName;
	}
	
	public void setConcernName(String concernName) {
		this.concernName = concernName;
	}
	
	public Gender getConcernFor() {
		return concernFor;
	}
	
	public void setConcernFor(Gender concernFor) {
		this.concernFor = concernFor;
	}
	
	public ConcernStatus getConcernStatus() {
		return concernStatus;
	}
	
	public void setConcernStatus(ConcernStatus concernStatus) {
		this.concernStatus = concernStatus;
	}
	
	public BloodDonor getBloodDonor() {
		return bloodDonor;
	}
	
	public void setBloodDonor(BloodDonor bloodDonor) {
		this.bloodDonor = bloodDonor;
	}
	
}
