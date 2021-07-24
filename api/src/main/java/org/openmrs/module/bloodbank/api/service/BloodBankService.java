package org.openmrs.module.bloodbank.api.service;

import org.openmrs.api.APIException;
import org.openmrs.api.OpenmrsService;
import org.openmrs.module.bloodbank.api.model.BloodCompatibility;
import org.openmrs.module.bloodbank.api.model.BloodDonorPhysicalSuitability;
import org.openmrs.module.bloodbank.api.model.BloodStockTracing;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BloodBankService extends OpenmrsService {
	
	@Transactional(readOnly = true)
	List<BloodDonorPhysicalSuitability> getAllDonorTestsResult();
	
	@Transactional
	BloodCompatibility saveBloodCompatibility(BloodCompatibility bloodCompatibility) throws APIException;
	
	@Transactional
	BloodCompatibility updateBloodCompatibility(BloodCompatibility bloodCompatibility);
	
	@Transactional(readOnly = true)
	List<BloodCompatibility> getAllBloodCompatibility();
	
	BloodCompatibility getBloodCompatibilityById(Integer id);
	
	@Transactional
	BloodStockTracing saveBloodStockTracing(BloodStockTracing bloodStockTracing);
	
	@Transactional
	BloodStockTracing updateBloodStockTracing(BloodStockTracing bloodStockTracing);
	
	@Transactional(readOnly = true)
	List<BloodStockTracing> getAllBloodStockTracing();
	
	BloodStockTracing getBloodStockTracingById(Integer id);
	
	BloodStockTracing getBloodStockTracingByBloodBagId(String bloodBagId);
	
	BloodCompatibility getCompatibilityByBagId(String bloodBagId);
	
	String getNextBloodBagId(String bloodSource);
	
	/*@Authorized()
	@Transactional(readOnly = true)
	Item getItemByUuid(String uuid) throws APIException;

	@Authorized(BloodBankConfig.MODULE_PRIVILEGE)
	@Transactional
	Item saveItem(Item item) throws APIException;*/
}
