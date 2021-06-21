package org.openmrs.module.bloodbank.api.service;

import org.openmrs.api.OpenmrsService;
import org.openmrs.module.bloodbank.api.model.BloodDonorPhysicalSuitability;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BloodBankService extends OpenmrsService {

    @Transactional(readOnly = true)
    List<BloodDonorPhysicalSuitability> getAllDonorTestsResult();

	/*@Authorized()
	@Transactional(readOnly = true)
	Item getItemByUuid(String uuid) throws APIException;

	@Authorized(BloodBankConfig.MODULE_PRIVILEGE)
	@Transactional
	Item saveItem(Item item) throws APIException;*/
}
