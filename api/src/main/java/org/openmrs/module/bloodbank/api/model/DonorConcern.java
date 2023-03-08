package org.openmrs.module.bloodbank.api.model;

import java.io.Serializable;
import org.codehaus.jackson.annotate.JsonBackReference;
import org.openmrs.module.bloodbank.api.model.enums.ConcernStatus;

public class DonorConcern implements Serializable {

  private Integer donorConcernId;

  private String concernName;

  private ConcernStatus concernStatus;

  @JsonBackReference private BloodDonor bloodDonor;

  public DonorConcern() {
    this.concernStatus = ConcernStatus.Yes;
  }

  public Integer getDonorConcernId() {
    return donorConcernId;
  }

  public void setDonorConcernId(Integer donorConcernId) {
    this.donorConcernId = donorConcernId;
  }

  public String getConcernName() {
    return concernName;
  }

  public void setConcernName(String concernName) {
    this.concernName = concernName;
  }

  public ConcernStatus getConcernStatus() {
    return this.concernStatus;
  }

  public void setConcernStatus(ConcernStatus concernStatus) {
    this.concernStatus = concernStatus;
  }

  public BloodDonor getBloodDonor() {
    return bloodDonor;
  }

  public void setBloodDonor(BloodDonor bloodDonor) {
    this.bloodDonor = bloodDonor;
  }
}
