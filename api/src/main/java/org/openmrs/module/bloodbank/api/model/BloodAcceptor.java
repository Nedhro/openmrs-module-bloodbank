package org.openmrs.module.bloodbank.api.model;

import java.io.Serializable;
import org.openmrs.BaseOpenmrsData;

public class BloodAcceptor extends BaseOpenmrsData implements Serializable {

  private Integer acceptorId;

  private String acceptorName;

  @Override
  public Integer getId() {
    return getAcceptorId();
  }

  @Override
  public void setId(Integer id) {
    setAcceptorId(id);
  }

  public Integer getAcceptorId() {
    return acceptorId;
  }

  public void setAcceptorId(Integer acceptorId) {
    this.acceptorId = acceptorId;
  }

  public String getAcceptorName() {
    return acceptorName;
  }

  public void setAcceptorName(String acceptorName) {
    this.acceptorName = acceptorName;
  }
}
