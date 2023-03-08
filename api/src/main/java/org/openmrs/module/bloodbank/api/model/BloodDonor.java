package org.openmrs.module.bloodbank.api.model;

import org.codehaus.jackson.annotate.JsonManagedReference;
import org.openmrs.module.bloodbank.api.model.enums.Gender;
import org.openmrs.module.bloodbank.api.model.enums.MaritalStatus;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class BloodDonor extends BaseModel {

    private Integer donorId;

    private String donorName;

    private Integer donorAge;

    private String donorGuardian;

    private Gender donorGender;

    private MaritalStatus donorMaritalStatus;

    private String donorProfession;

    private String donorPresentAddress;

    private String donorPermanentAddress;

    private String donorMobileNo;

    private Date donorLastDonatedDate;

    private String donorLastDonatedPlace;

    private String typeOfDonor;

    private Integer patientId;

    private String patient;

    @JsonManagedReference
    private Set<DonorConcern> concernSet = new HashSet<>();

    public BloodDonor() {
    }

    public BloodDonor(Integer donorId, String donorName, Integer donorAge, String donorGuardian, Gender donorGender, MaritalStatus donorMaritalStatus, String donorProfession, String donorPresentAddress, String donorPermanentAddress, String donorMobileNo, Date donorLastDonatedDate, String donorLastDonatedPlace, String typeOfDonor, Integer patientId, String patient, Set<DonorConcern> concernSet) {
        this.donorId = donorId;
        this.donorName = donorName;
        this.donorAge = donorAge;
        this.donorGuardian = donorGuardian;
        this.donorGender = donorGender;
        this.donorMaritalStatus = donorMaritalStatus;
        this.donorProfession = donorProfession;
        this.donorPresentAddress = donorPresentAddress;
        this.donorPermanentAddress = donorPermanentAddress;
        this.donorMobileNo = donorMobileNo;
        this.donorLastDonatedDate = donorLastDonatedDate;
        this.donorLastDonatedPlace = donorLastDonatedPlace;
        this.typeOfDonor = typeOfDonor;
        this.patientId = patientId;
        this.patient = patient;
        this.concernSet = concernSet;
    }

    public Integer getDonorId() {
        return donorId;
    }

    public void setDonorId(Integer donorId) {
        this.donorId = donorId;
    }

    public String getDonorName() {
        return donorName;
    }

    public void setDonorName(String donorName) {
        this.donorName = donorName;
    }

    public Integer getDonorAge() {
        return donorAge;
    }

    public void setDonorAge(Integer donorAge) {
        this.donorAge = donorAge;
    }

    public String getDonorGuardian() {
        return donorGuardian;
    }

    public void setDonorGuardian(String donorGuardian) {
        this.donorGuardian = donorGuardian;
    }

    public Gender getDonorGender() {
        return donorGender;
    }

    public void setDonorGender(Gender donorGender) {
        this.donorGender = donorGender;
    }

    public MaritalStatus getDonorMaritalStatus() {
        return donorMaritalStatus;
    }

    public void setDonorMaritalStatus(MaritalStatus donorMaritalStatus) {
        this.donorMaritalStatus = donorMaritalStatus;
    }

    public String getDonorProfession() {
        return donorProfession;
    }

    public void setDonorProfession(String donorProfession) {
        this.donorProfession = donorProfession;
    }

    public String getDonorPresentAddress() {
        return donorPresentAddress;
    }

    public void setDonorPresentAddress(String donorPresentAddress) {
        this.donorPresentAddress = donorPresentAddress;
    }

    public String getDonorPermanentAddress() {
        return donorPermanentAddress;
    }

    public void setDonorPermanentAddress(String donorPermanentAddress) {
        this.donorPermanentAddress = donorPermanentAddress;
    }

    public String getDonorMobileNo() {
        return donorMobileNo;
    }

    public void setDonorMobileNo(String donorMobileNo) {
        this.donorMobileNo = donorMobileNo;
    }

    public Date getDonorLastDonatedDate() {
        return donorLastDonatedDate;
    }

    public void setDonorLastDonatedDate(Date donorLastDonatedDate) {
        this.donorLastDonatedDate = donorLastDonatedDate;
    }

    public String getDonorLastDonatedPlace() {
        return donorLastDonatedPlace;
    }

    public void setDonorLastDonatedPlace(String donorLastDonatedPlace) {
        this.donorLastDonatedPlace = donorLastDonatedPlace;
    }

    public String getTypeOfDonor() {
        return typeOfDonor;
    }

    public void setTypeOfDonor(String typeOfDonor) {
        this.typeOfDonor = typeOfDonor;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public String getPatient() {
        return patient;
    }

    public void setPatient(String patient) {
        this.patient = patient;
    }

    public Set<DonorConcern> getConcernSet() {
        return concernSet;
    }

    public void setConcernSet(Set<DonorConcern> concernSet) {
        this.concernSet = concernSet;
    }
}
