package org.openmrs.module.bloodbank.api.model;

public class BloodBankUtil extends BaseModel {

	private Integer utilId;

	private String property;

	private String propertyValue;

	private String description;

	public BloodBankUtil() {
	}

	public BloodBankUtil(String property, String propertyValue, String description) {
		this.property = property;
		this.propertyValue = propertyValue;
		this.description = description;
	}

	public Integer getUtilId() {
		return utilId;
	}

	public void setUtilId(Integer utilId) {
		this.utilId = utilId;
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public String getPropertyValue() {
		return propertyValue;
	}

	public void setPropertyValue(String propertyValue) {
		this.propertyValue = propertyValue;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
