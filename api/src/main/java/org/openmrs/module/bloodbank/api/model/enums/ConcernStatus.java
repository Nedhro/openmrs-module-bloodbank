package org.openmrs.module.bloodbank.api.model.enums;

public enum ConcernStatus {
  Yes("Yes"),
  No("No");

  private final String value;

  ConcernStatus(String value) {
    this.value = value;
  }

  public String getValue() {
    return this.value;
  }
}
