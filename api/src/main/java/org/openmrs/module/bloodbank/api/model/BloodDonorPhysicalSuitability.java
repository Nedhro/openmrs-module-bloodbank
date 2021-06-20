package org.openmrs.module.bloodbank.api.model;

import org.openmrs.module.bloodbank.api.model.enums.PermissionType;

public class BloodDonorPhysicalSuitability extends BaseModel {

    private Integer donorPhysicalSuitabilityId;

    private Double donorHemoglobin;

    private Double donorWeight;

    private String donorBloodPressure;

    private Double donorPulseRate;

    private Double donorTemperature;

    private String donorBloodGroup;

    private String donorBloodGroupRhesus;

    private PermissionType donorSelection;

    private Integer bloodDonorId;

    public BloodDonorPhysicalSuitability() {
	}

    public BloodDonorPhysicalSuitability(Integer donorPhysicalSuitabilityId, Double donorHemoglobin, Double donorWeight,
                                         String donorBloodPressure, Double donorPulseRate, Double donorTemperature, String donorBloodGroup,
                                         String donorBloodGroupRhesus, PermissionType donorSelection, Integer bloodDonorId) {
        this.donorPhysicalSuitabilityId = donorPhysicalSuitabilityId;
        this.donorHemoglobin = donorHemoglobin;
        this.donorWeight = donorWeight;
        this.donorBloodPressure = donorBloodPressure;
        this.donorPulseRate = donorPulseRate;
        this.donorTemperature = donorTemperature;
        this.donorBloodGroup = donorBloodGroup;
        this.donorBloodGroupRhesus = donorBloodGroupRhesus;
        this.donorSelection = donorSelection;
        this.bloodDonorId = bloodDonorId;
	}

    public Integer getDonorPhysicalSuitabilityId() {
		return donorPhysicalSuitabilityId;
	}

    public void setDonorPhysicalSuitabilityId(Integer donorPhysicalSuitabilityId) {
		this.donorPhysicalSuitabilityId = donorPhysicalSuitabilityId;
	}

    public Double getDonorHemoglobin() {
		return donorHemoglobin;
	}

    public void setDonorHemoglobin(Double donorHemoglobin) {
		this.donorHemoglobin = donorHemoglobin;
	}

    public Double getDonorWeight() {
		return donorWeight;
	}

    public void setDonorWeight(Double donorWeight) {
		this.donorWeight = donorWeight;
	}

    public String getDonorBloodPressure() {
		return donorBloodPressure;
	}

    public void setDonorBloodPressure(String donorBloodPressure) {
		this.donorBloodPressure = donorBloodPressure;
	}

    public Double getDonorPulseRate() {
		return donorPulseRate;
	}

    public void setDonorPulseRate(Double donorPulseRate) {
		this.donorPulseRate = donorPulseRate;
	}

    public Double getDonorTemperature() {
		return donorTemperature;
	}

    public void setDonorTemperature(Double donorTemperature) {
		this.donorTemperature = donorTemperature;
	}

    public String getDonorBloodGroup() {
		return donorBloodGroup;
	}

    public void setDonorBloodGroup(String donorBloodGroup) {
		this.donorBloodGroup = donorBloodGroup;
	}

    public String getDonorBloodGroupRhesus() {
		return donorBloodGroupRhesus;
	}

    public void setDonorBloodGroupRhesus(String donorBloodGroupRhesus) {
		this.donorBloodGroupRhesus = donorBloodGroupRhesus;
	}

    public PermissionType getDonorSelection() {
		return donorSelection;
	}

    public void setDonorSelection(PermissionType donorSelection) {
		this.donorSelection = donorSelection;
	}

    public Integer getBloodDonorId() {
		return bloodDonorId;
	}

    public void setBloodDonorId(Integer bloodDonorId) {
		this.bloodDonorId = bloodDonorId;
	}
}
