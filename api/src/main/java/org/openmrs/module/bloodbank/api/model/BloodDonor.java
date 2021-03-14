package org.openmrs.module.bloodbank.api.model;

import org.openmrs.BaseOpenmrsData;

import java.io.Serializable;
import java.util.Date;

public class BloodDonor extends BaseOpenmrsData implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String donorId;
	
	private String donorName;
	
	private String donorAge;
	
	private String donorGuardian;
	
	private String donorGender;
	
	private String donorMaritalStatus;
	
	private String donorProfession;
	
	private String donorPresentAddress;
	
	private String donorPermanentAddress;
	
	private String donorMobileNo;
	
	private Date donorLastDonatedDate;
	
	private String donorLastDonatedPlace;
	
	public BloodDonor() {
	}
	
	public BloodDonor(String donorId, String donorName, String donorAge, String donorGuardian, String donorGender,
	    String donorMaritalStatus, String donorProfession, String donorPresentAddress, String donorPermanentAddress,
	    String donorMobileNo, Date donorLastDonatedDate, String donorLastDonatedPlace) {
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
	}
	
	@Override
	public Integer getId() {
		return null;
	}
	
	@Override
	public void setId(Integer integer) {
		
	}
	
	public String getDonorId() {
		return donorId;
	}
	
	public void setDonorId(String donorId) {
		this.donorId = donorId;
	}
	
	public String getDonorName() {
		return donorName;
	}
	
	public void setDonorName(String donorName) {
		this.donorName = donorName;
	}
	
	public String getDonorAge() {
		return donorAge;
	}
	
	public void setDonorAge(String donorAge) {
		this.donorAge = donorAge;
	}
	
	public String getDonorGuardian() {
		return donorGuardian;
	}
	
	public void setDonorGuardian(String donorGuardian) {
		this.donorGuardian = donorGuardian;
	}
	
	public String getDonorGender() {
		return donorGender;
	}
	
	public void setDonorGender(String donorGender) {
		this.donorGender = donorGender;
	}
	
	public String getDonorMaritalStatus() {
		return donorMaritalStatus;
	}
	
	public void setDonorMaritalStatus(String donorMaritalStatus) {
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
}
