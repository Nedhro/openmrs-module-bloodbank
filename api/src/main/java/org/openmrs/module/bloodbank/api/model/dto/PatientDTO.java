package org.openmrs.module.bloodbank.api.model.dto;

public class PatientDTO {
	
	private Integer patient_id;
	
	private String identifier;
	
	private String uuid;
	
	private String name;
	
	public PatientDTO() {
	}
	
	public PatientDTO(Integer patient_id, String identifier, String uuid, String name) {
		this.patient_id = patient_id;
		this.identifier = identifier;
		this.uuid = uuid;
		this.name = name;
	}
	
	public Integer getPatient_id() {
		return patient_id;
	}
	
	public void setPatient_id(Integer patient_id) {
		this.patient_id = patient_id;
	}
	
	public String getIdentifier() {
		return identifier;
	}
	
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	
	public String getUuid() {
		return uuid;
	}
	
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
