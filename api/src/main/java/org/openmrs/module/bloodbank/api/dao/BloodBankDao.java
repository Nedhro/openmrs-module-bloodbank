package org.openmrs.module.bloodbank.api.dao;

import java.util.List;
import org.openmrs.module.bloodbank.api.model.BloodCompatibility;
import org.openmrs.module.bloodbank.api.model.BloodDonorPhysicalSuitability;
import org.openmrs.module.bloodbank.api.model.BloodStockTracing;

public interface BloodBankDao {

  List<BloodDonorPhysicalSuitability> getAllDonorTestsResult();

  BloodCompatibility saveBloodCompatibility(BloodCompatibility bloodCompatibility);

  BloodCompatibility updateBloodCompatibility(BloodCompatibility bloodCompatibility);

  List<BloodCompatibility> getAllBloodCompatibility();

  BloodCompatibility getBloodCompatibilityById(Integer id);

  BloodStockTracing saveBloodStockTracing(BloodStockTracing bloodStockTracing);

  BloodStockTracing updateBloodStockTracing(BloodStockTracing bloodStockTracing);

  List<BloodStockTracing> getAllBloodStockTracing();

  BloodStockTracing getBloodStockTracingById(Integer id);

  BloodStockTracing getBloodStockTracingByBloodBagId(String bloodBagId);

  BloodCompatibility getCompatibilityByBagId(String bloodBagId);

  String getNextBloodBagId(String bloodSource);
}
