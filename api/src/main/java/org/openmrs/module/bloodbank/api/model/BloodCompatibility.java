package org.openmrs.module.bloodbank.api.model;

public class BloodCompatibility extends BaseModel {
	
	private Integer bloodCompatibilityId;
	
	private String bloodScreening;
	
	private String bloodGrouping;
	
	private String bloodHivTest;

  private String bloodHbvTest;

  private String bloodHcvTest;

  private String bloodSyphilisTest;

  private String bloodMalariaTest;

  private String bloodBagId;

  private Integer patientId;

  private String patient;

  private String patientBloodGroup;

  private String patientBloodGroupRhesus;

  private String atRoomTemp;

  private String at37ByICT;
	
	private String coombsTest;
	
	public BloodCompatibility() {
	}

  public BloodCompatibility(Integer bloodCompatibilityId, String bloodScreening,
      String bloodGrouping,
      String bloodHivTest, String bloodHbvTest, String bloodHcvTest, String bloodSyphilisTest,
      String bloodMalariaTest,
      String bloodBagId, Integer patientId, String patient, String patientBloodGroup,
      String patientBloodGroupRhesus,
      String atRoomTemp, String at37ByICT, String coombsTest) {
    this.bloodCompatibilityId = bloodCompatibilityId;
    this.bloodScreening = bloodScreening;
    this.bloodGrouping = bloodGrouping;
    this.bloodHivTest = bloodHivTest;
    this.bloodHbvTest = bloodHbvTest;
    this.bloodHcvTest = bloodHcvTest;
    this.bloodSyphilisTest = bloodSyphilisTest;
    this.bloodMalariaTest = bloodMalariaTest;
    this.bloodBagId = bloodBagId;
    this.patientId = patientId;
		this.patient = patient;
		this.patientBloodGroup = patientBloodGroup;
		this.patientBloodGroupRhesus = patientBloodGroupRhesus;
		this.atRoomTemp = atRoomTemp;
		this.at37ByICT = at37ByICT;
		this.coombsTest = coombsTest;
	}
	
	public Integer getBloodCompatibilityId() {
		return bloodCompatibilityId;
	}
	
	public void setBloodCompatibilityId(Integer bloodCompatibilityId) {
		this.bloodCompatibilityId = bloodCompatibilityId;
	}
	
	public String getBloodScreening() {
		return bloodScreening;
	}
	
	public void setBloodScreening(String bloodScreening) {
		this.bloodScreening = bloodScreening;
	}
	
	public String getBloodGrouping() {
		return bloodGrouping;
	}
	
	public void setBloodGrouping(String bloodGrouping) {
		this.bloodGrouping = bloodGrouping;
	}
	
	public String getBloodHivTest() {
		return bloodHivTest;
	}
	
	public void setBloodHivTest(String bloodHivTest) {
		this.bloodHivTest = bloodHivTest;
	}
	
	public String getBloodHbvTest() {
		return bloodHbvTest;
	}
	
	public void setBloodHbvTest(String bloodHbvTest) {
		this.bloodHbvTest = bloodHbvTest;
	}
	
	public String getBloodHcvTest() {
		return bloodHcvTest;
	}
	
	public void setBloodHcvTest(String bloodHcvTest) {
		this.bloodHcvTest = bloodHcvTest;
	}
	
	public String getBloodSyphilisTest() {
		return bloodSyphilisTest;
	}
	
	public void setBloodSyphilisTest(String bloodSyphilisTest) {
		this.bloodSyphilisTest = bloodSyphilisTest;
	}
	
	public String getBloodMalariaTest() {
		return bloodMalariaTest;
	}
	
	public void setBloodMalariaTest(String bloodMalariaTest) {
		this.bloodMalariaTest = bloodMalariaTest;
	}

  public String getBloodBagId() {
		return bloodBagId;
	}

  public void setBloodBagId(String bloodBagId) {
		this.bloodBagId = bloodBagId;
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

  public String getPatientBloodGroup() {
		return patientBloodGroup;
	}
	
	public void setPatientBloodGroup(String patientBloodGroup) {
		this.patientBloodGroup = patientBloodGroup;
	}
	
	public String getPatientBloodGroupRhesus() {
		return patientBloodGroupRhesus;
	}
	
	public void setPatientBloodGroupRhesus(String patientBloodGroupRhesus) {
		this.patientBloodGroupRhesus = patientBloodGroupRhesus;
	}
	
	public String getAtRoomTemp() {
		return atRoomTemp;
	}
	
	public void setAtRoomTemp(String atRoomTemp) {
		this.atRoomTemp = atRoomTemp;
	}
	
	public String getAt37ByICT() {
		return at37ByICT;
	}
	
	public void setAt37ByICT(String at37ByICT) {
		this.at37ByICT = at37ByICT;
	}
	
	public String getCoombsTest() {
		return coombsTest;
	}
	
	public void setCoombsTest(String coombsTest) {
		this.coombsTest = coombsTest;
	}
}
