package org.openmrs.module.bloodbank.api.model.enums;

public enum StockStatus {
  Available("Available"),
  NotAvailable("NotAvailable");

  private final String value;

  StockStatus(String value) {
    this.value = value;
  }

  public String getValue() {
    return this.value;
  }
}
