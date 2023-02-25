package org.openmrs.module.bloodbank.api.model.dto;

public class PatientDTO {

  private Integer patient_id;

  private String uuid;

  private String name;

  private String age;

  private String gender;

  private String bed;

  private String ward;

  private String unit;

  public PatientDTO() {
  }

  public PatientDTO(Integer patient_id, String uuid, String name, String age, String gender,
      String bed, String ward,
      String unit) {
    this.patient_id = patient_id;
    this.uuid = uuid;
    this.name = name;
    this.age = age;
    this.gender = gender;
    this.bed = bed;
    this.ward = ward;
    this.unit = unit;
  }

  public Integer getPatient_id() {
    return patient_id;
  }

  public void setPatient_id(Integer patient_id) {
    this.patient_id = patient_id;
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

  public String getAge() {
    return age;
  }

  public void setAge(String age) {
    this.age = age;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getBed() {
    return bed;
  }

  public void setBed(String bed) {
    this.bed = bed;
  }

  public String getWard() {
		return ward;
	}
	
	public void setWard(String ward) {
		this.ward = ward;
	}
	
	public String getUnit() {
		return unit;
	}
	
	public void setUnit(String unit) {
		this.unit = unit;
	}
}
