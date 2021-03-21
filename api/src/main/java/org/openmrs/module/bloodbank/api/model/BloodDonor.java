package org.openmrs.module.bloodbank.api.model;

import org.codehaus.jackson.annotate.JsonManagedReference;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

public class BloodDonor implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer donorId;
	
	private String donorName;
	
	private Integer donorAge;
	
	private String donorGuardian;
	
	private String donorGender;
	
	private String donorMaritalStatus;
	
	private String donorProfession;
	
	private String donorPresentAddress;
	
	private String donorPermanentAddress;
	
	private String donorMobileNo;
	
	private Date donorLastDonatedDate;
	
	private String donorLastDonatedPlace;
	
	@JsonManagedReference
	private Set<DonorConcern> concernSet;
	
	public Set<DonorConcern> getConcernSet() {
		return concernSet;
	}
	
	public void setConcernSet(Set<DonorConcern> concernSet) {
		this.concernSet = concernSet;
	}
	
	public BloodDonor() {
	}
	
	public BloodDonor(Integer donorId, String donorName, Integer donorAge, String donorGuardian, String donorGender,
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
	
	/*	@Override
		public Integer getId() {
			return getDonorId();
		}

		@Override
		public void setId(Integer id) {
			setDonorId(id);
		}*/
	
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
