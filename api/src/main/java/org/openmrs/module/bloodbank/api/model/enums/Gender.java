package org.openmrs.module.bloodbank.api.model.enums;

public enum Gender {
  Male("Male"),
  Female("Female"),
  Other("Other"),
  Both("Both");

  private final String value;

  Gender(String value) {
    this.value = value;
  }

  public String getValue() {
    return this.value;
  }
}
