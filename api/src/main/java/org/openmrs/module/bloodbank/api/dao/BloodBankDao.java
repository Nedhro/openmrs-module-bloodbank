package org.openmrs.module.bloodbank.api.dao;

import org.openmrs.module.bloodbank.api.model.BloodCompatibility;
import org.openmrs.module.bloodbank.api.model.BloodDonorPhysicalSuitability;

import java.util.List;

public interface BloodBankDao {
	
	List<BloodDonorPhysicalSuitability> getAllDonorTestsResult();
	
	BloodCompatibility saveBloodDonorPhysicalSuitability(BloodCompatibility bloodCompatibility);
	
	BloodCompatibility updateBloodCompatibility(BloodCompatibility bloodCompatibility);
	
	List<BloodCompatibility> getAllBloodCompatibility();
	
	BloodCompatibility getBloodCompatibilityById(Integer id);
}
