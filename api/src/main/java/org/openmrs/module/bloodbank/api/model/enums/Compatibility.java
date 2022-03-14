package org.openmrs.module.bloodbank.api.model.enums;

public enum Compatibility {
	Compatible("Compatible"), Incompatible("Incompatible"), NonCompatible("Non-Compatible"), NotDone("Not Done");
	
	private final String value;
	
	Compatibility(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
}
