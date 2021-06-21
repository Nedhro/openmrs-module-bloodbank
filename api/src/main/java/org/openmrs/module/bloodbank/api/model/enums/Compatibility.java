package org.openmrs.module.bloodbank.api.model.enums;

public enum Compatibility {
	Compatible("Compatible"), NonCompatible("Non-Compatible");
	
	private final String value;
	
	Compatibility(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
}
