package org.openmrs.module.bloodbank.api.service;

import org.openmrs.api.APIException;
import org.openmrs.api.OpenmrsService;
import org.openmrs.module.bloodbank.api.model.BloodCompatibility;
import org.openmrs.module.bloodbank.api.model.BloodDonorPhysicalSuitability;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BloodBankService extends OpenmrsService {
	
	@Transactional(readOnly = true)
	List<BloodDonorPhysicalSuitability> getAllDonorTestsResult();
	
	@Transactional
	BloodCompatibility saveBloodDonorPhysicalSuitability(BloodCompatibility bloodCompatibility) throws APIException;
	
	@Transactional
	BloodCompatibility updateBloodCompatibility(BloodCompatibility bloodCompatibility);
	
	@Transactional(readOnly = true)
	List<BloodCompatibility> getAllBloodCompatibility();
	
	BloodCompatibility getBloodCompatibilityById(Integer id);
	
	/*@Authorized()
	@Transactional(readOnly = true)
	Item getItemByUuid(String uuid) throws APIException;

	@Authorized(BloodBankConfig.MODULE_PRIVILEGE)
	@Transactional
	Item saveItem(Item item) throws APIException;*/
}
