package org.openmrs.module.bloodbank.api.model;

public enum ConcernStatus {
	YES("yes"), NO("no");
	
	private final String value;
	
	ConcernStatus(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
}
