package org.openmrs.module.bloodbank.api.model.enums;

public enum SourceOfBlood {
	NITOR("NITOR"), OutdoorCampaign("Outdoor Campaign"), Outsource("Outsource");
	
	private final String value;
	
	SourceOfBlood(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
}
