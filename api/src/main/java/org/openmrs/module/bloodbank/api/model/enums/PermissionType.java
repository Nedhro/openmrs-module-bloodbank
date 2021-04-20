package org.openmrs.module.bloodbank.api.model.enums;

public enum PermissionType {
	Selected("Selected"), Rejected("Rejected");

	private final String value;

	PermissionType(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}
}
