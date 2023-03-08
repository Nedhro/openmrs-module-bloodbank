package org.openmrs.module.bloodbank.api.model.enums;

public enum MaritalStatus {
  Single("Single"),
  Married("Married"),
  Widowed("Widowed"),
  Separated("Separated"),
  Divorced("Divorced");

  private final String value;

  MaritalStatus(String value) {
    this.value = value;
  }

  public String getValue() {
    return this.value;
  }
}
