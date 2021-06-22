package org.openmrs.module.bloodbank.api.model.enums;

public enum DonorType {
	Voluntary("Voluntary"), Directory("Directory"), Others("Others");
	
	private final String value;
	
	DonorType(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
}
