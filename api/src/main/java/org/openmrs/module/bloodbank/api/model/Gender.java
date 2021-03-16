package org.openmrs.module.bloodbank.api.model;

public enum Gender {
	MALE("male"), FEMALE("female"), OTHER("other"), BOTH("both");
	
	private final String value;
	
	Gender(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
}
