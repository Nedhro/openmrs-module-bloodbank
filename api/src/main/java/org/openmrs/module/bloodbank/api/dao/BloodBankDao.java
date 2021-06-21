package org.openmrs.module.bloodbank.api.dao;

import org.openmrs.module.bloodbank.api.model.BloodDonorPhysicalSuitability;

import java.util.List;

public interface BloodBankDao {
	
	List<BloodDonorPhysicalSuitability> getAllDonorTestsResult();
}
