package org.openmrs.module.bloodbank.api.model;

import org.hibernate.type.EnumType;
import org.openmrs.module.bloodbank.api.model.enums.Compatibility;
import org.openmrs.module.bloodbank.api.model.enums.Result;

public class BloodCompatibility extends BaseModel {
	
	private Integer bloodCompatibilityId;
	
	private Compatibility bloodScreening;
	
	private Compatibility bloodGrouping;
	
	private Compatibility bloodCrossMatching;
	
	private Result bloodHivTest;
	
	private Result bloodHbvTest;
	
	private Result bloodHcvTest;
	
	private Result bloodSyphilisTest;
	
	private Result bloodMalariaTest;
	
	public BloodCompatibility() {
	}
	
	public BloodCompatibility(Integer bloodCompatibilityId, Compatibility bloodScreening, Compatibility bloodGrouping,
	    Compatibility bloodCrossMatching, Result bloodHivTest, Result bloodHbvTest, Result bloodHcvTest,
	    Result bloodSyphilisTest, Result bloodMalariaTest) {
		this.bloodCompatibilityId = bloodCompatibilityId;
		this.bloodScreening = bloodScreening;
		this.bloodGrouping = bloodGrouping;
		this.bloodCrossMatching = bloodCrossMatching;
		this.bloodHivTest = bloodHivTest;
		this.bloodHbvTest = bloodHbvTest;
		this.bloodHcvTest = bloodHcvTest;
		this.bloodSyphilisTest = bloodSyphilisTest;
		this.bloodMalariaTest = bloodMalariaTest;
	}
	
	public Integer getBloodCompatibilityId() {
		return bloodCompatibilityId;
	}
	
	public void setBloodCompatibilityId(Integer bloodCompatibilityId) {
		this.bloodCompatibilityId = bloodCompatibilityId;
	}
	
	public Compatibility getBloodScreening() {
		return bloodScreening;
	}
	
	public void setBloodScreening(Compatibility bloodScreening) {
		this.bloodScreening = bloodScreening;
	}
	
	public Compatibility getBloodGrouping() {
		return bloodGrouping;
	}
	
	public void setBloodGrouping(Compatibility bloodGrouping) {
		this.bloodGrouping = bloodGrouping;
	}
	
	public Compatibility getBloodCrossMatching() {
		return bloodCrossMatching;
	}
	
	public void setBloodCrossMatching(Compatibility bloodCrossMatching) {
		this.bloodCrossMatching = bloodCrossMatching;
	}
	
	public Result getBloodHivTest() {
		return bloodHivTest;
	}
	
	public void setBloodHivTest(Result bloodHivTest) {
		this.bloodHivTest = bloodHivTest;
	}
	
	public Result getBloodHbvTest() {
		return bloodHbvTest;
	}
	
	public void setBloodHbvTest(Result bloodHbvTest) {
		this.bloodHbvTest = bloodHbvTest;
	}
	
	public Result getBloodHcvTest() {
		return bloodHcvTest;
	}
	
	public void setBloodHcvTest(Result bloodHcvTest) {
		this.bloodHcvTest = bloodHcvTest;
	}
	
	public Result getBloodSyphilisTest() {
		return bloodSyphilisTest;
	}
	
	public void setBloodSyphilisTest(Result bloodSyphilisTest) {
		this.bloodSyphilisTest = bloodSyphilisTest;
	}
	
	public Result getBloodMalariaTest() {
		return bloodMalariaTest;
	}
	
	public void setBloodMalariaTest(Result bloodMalariaTest) {
		this.bloodMalariaTest = bloodMalariaTest;
	}
}