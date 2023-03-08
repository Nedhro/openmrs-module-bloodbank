package org.openmrs.module.bloodbank.api.model.enums;

public enum BloodComponent {
	WholeBlood("Whole Blood"), RCC("RCC"), FFP("FFP"), Platelet("Platelet");
	
	private final String value;
	
	BloodComponent(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
}
