package org.openmrs.module.bloodbank.api.service;

import org.openmrs.api.OpenmrsService;

public interface BloodBankService extends OpenmrsService {
	
	/*@Authorized()
	@Transactional(readOnly = true)
	Item getItemByUuid(String uuid) throws APIException;

	@Authorized(BloodBankConfig.MODULE_PRIVILEGE)
	@Transactional
	Item saveItem(Item item) throws APIException;*/
}
