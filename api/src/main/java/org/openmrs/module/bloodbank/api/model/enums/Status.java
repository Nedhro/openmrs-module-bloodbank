package org.openmrs.module.bloodbank.api.model.enums;

public enum Status {
	ACTIVE(1), ARCHIVE(2), DELETE(3), OPEN(4), CLOSED(5), PREVIOUS(6);
	
	private final int value;
	
	Status(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return this.value;
	}
	
}
