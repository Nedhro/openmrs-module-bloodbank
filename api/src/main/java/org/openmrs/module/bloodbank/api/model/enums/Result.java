package org.openmrs.module.bloodbank.api.model.enums;

public enum Result {
	Positive("Positive"), Negative("Negative"), Reactive("Reactive"), NonReactive("Non-Reactive");
	
	private final String value;
	
	Result(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
}
