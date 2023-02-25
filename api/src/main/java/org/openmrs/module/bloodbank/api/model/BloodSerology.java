package org.openmrs.module.bloodbank.api.model;

public class BloodSerology extends BaseModel {

  private Integer bloodSerologyId;

  private String bloodScreening;

  private String bloodGrouping;

  private String bloodHivTest;

  private String bloodHbvTest;

  private String bloodHcvTest;

  private String bloodSyphilisTest;

  private String bloodMalariaTest;

  private Integer patientId;

  private String patientName;

  private String patientBloodGroup;

  private String patientBloodGroupRhesus;

  private String atRoomTemp;

  private String at37ByICT;

  private String coombsTest;

  public BloodSerology() {
  }

  public BloodSerology(Integer bloodSerologyId, String bloodScreening, String bloodGrouping,
      String bloodHivTest,
      String bloodHbvTest, String bloodHcvTest, String bloodSyphilisTest, String bloodMalariaTest,
      Integer patientId,
      String patientName, String patientBloodGroup, String patientBloodGroupRhesus,
      String atRoomTemp, String at37ByICT,
      String coombsTest) {
    this.bloodSerologyId = bloodSerologyId;
    this.bloodScreening = bloodScreening;
    this.bloodGrouping = bloodGrouping;
    this.bloodHivTest = bloodHivTest;
    this.bloodHbvTest = bloodHbvTest;
    this.bloodHcvTest = bloodHcvTest;
    this.bloodSyphilisTest = bloodSyphilisTest;
    this.bloodMalariaTest = bloodMalariaTest;
    this.patientId = patientId;
    this.patientName = patientName;
    this.patientBloodGroup = patientBloodGroup;
    this.patientBloodGroupRhesus = patientBloodGroupRhesus;
    this.atRoomTemp = atRoomTemp;
    this.at37ByICT = at37ByICT;
    this.coombsTest = coombsTest;
  }

  public Integer getBloodSerologyId() {
    return bloodSerologyId;
  }

  public void setBloodSerologyId(Integer bloodSerologyId) {
    this.bloodSerologyId = bloodSerologyId;
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

  public Integer getPatientId() {
    return patientId;
  }

  public void setPatientId(Integer patientId) {
    this.patientId = patientId;
  }

  public String getPatientName() {
    return patientName;
  }

  public void setPatientName(String patientName) {
    this.patientName = patientName;
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
