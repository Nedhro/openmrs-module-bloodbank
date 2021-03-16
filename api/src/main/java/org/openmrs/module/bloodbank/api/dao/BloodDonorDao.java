package org.openmrs.module.bloodbank.api.dao;

import org.openmrs.module.bloodbank.api.model.BloodDonor;

import java.util.List;

public interface BloodDonorDao {
	
	List<BloodDonor> getAllBloodDonors();
}
