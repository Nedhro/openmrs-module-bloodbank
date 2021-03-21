package org.openmrs.module.bloodbank.api.service;

import org.openmrs.api.APIException;
import org.openmrs.api.OpenmrsService;
import org.openmrs.module.bloodbank.api.model.BloodDonor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BloodDonorService extends OpenmrsService {
	
	@Transactional
	List<BloodDonor> getAllBloodDonors();
	
	@Transactional
	BloodDonor saveDonorInfo(BloodDonor bloodDonor) throws APIException;
}
