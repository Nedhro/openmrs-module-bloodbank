package org.openmrs.module.bloodbank.api.service.impl;

import java.util.List;
import org.openmrs.api.UserService;
import org.openmrs.api.impl.BaseOpenmrsService;
import org.openmrs.module.bloodbank.api.dao.BloodBankDao;
import org.openmrs.module.bloodbank.api.model.BloodCompatibility;
import org.openmrs.module.bloodbank.api.model.BloodDonorPhysicalSuitability;
import org.openmrs.module.bloodbank.api.model.BloodSerology;
import org.openmrs.module.bloodbank.api.model.BloodStockTracing;
import org.openmrs.module.bloodbank.api.service.BloodBankService;

public class BloodBankServiceImpl extends BaseOpenmrsService implements BloodBankService {
	
	private BloodBankDao bloodBankDao;
	
	private UserService userService;
	
	public void setBloodBankDao(BloodBankDao bloodBankDao) {
		this.bloodBankDao = bloodBankDao;
	}
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@Override
	public List<BloodDonorPhysicalSuitability> getAllDonorTestsResult() {
		return bloodBankDao.getAllDonorTestsResult();
	}
	
	@Override
	public BloodCompatibility saveBloodCompatibility(BloodCompatibility bloodCompatibility) {
		return bloodBankDao.saveBloodCompatibility(bloodCompatibility);
	}
	
	@Override
	public BloodCompatibility updateBloodCompatibility(BloodCompatibility bloodCompatibility) {
		return bloodBankDao.updateBloodCompatibility(bloodCompatibility);
	}
	
	@Override
	public List<BloodCompatibility> getAllBloodCompatibility() {
		return bloodBankDao.getAllBloodCompatibility();
	}
	
	@Override
	public BloodCompatibility getBloodCompatibilityById(Integer id) {
		return bloodBankDao.getBloodCompatibilityById(id);
	}
	
	@Override
	public BloodStockTracing saveBloodStockTracing(BloodStockTracing bloodStockTracing) {
		return bloodBankDao.saveBloodStockTracing(bloodStockTracing);
	}

	@Override
	public BloodStockTracing updateBloodStockTracing(BloodStockTracing bloodStockTracing) {
		return bloodBankDao.updateBloodStockTracing(bloodStockTracing);
	}

	@Override
	public List<BloodStockTracing> getAllBloodStockTracing() {
		return bloodBankDao.getAllBloodStockTracing();
	}

	@Override
	public List<BloodStockTracing> getAllBloodStockTracingApproved() {
		return bloodBankDao.getAllBloodStockTracingApproved();
	}

	@Override
	public BloodStockTracing getBloodStockTracingById(Integer id) {
		return bloodBankDao.getBloodStockTracingById(id);
	}

	@Override
	public BloodStockTracing getBloodStockTracingByBloodBagId(String bloodBagId) {
		return bloodBankDao.getBloodStockTracingByBloodBagId(bloodBagId);
	}

	@Override
	public BloodCompatibility getCompatibilityByBagId(String bloodBagId) {
		return bloodBankDao.getCompatibilityByBagId(bloodBagId);
	}

	@Override
	public String getNextBloodBagId(String bloodSource) {
		return bloodBankDao.getNextBloodBagId(bloodSource);
	}

	@Override
	public BloodSerology saveBloodSerology(BloodSerology bloodSerology) {
		return bloodBankDao.saveBloodSerology(bloodSerology);
	}

	@Override
	public BloodSerology updateBloodSerology(BloodSerology bloodSerology) {
		return bloodBankDao.updateBloodSerology(bloodSerology);
	}

	@Override
	public List<BloodSerology> getAllBloodSerology() {
		return bloodBankDao.getAllBloodSerology();
	}

	@Override
	public BloodSerology getBloodSerologyById(Integer id) {
		return bloodBankDao.getBloodSerologyById(id);
	}

	@Override
	public BloodSerology getBloodSerologyByPatientId(Integer id) {
		return bloodBankDao.getBloodSerologyByPatientId(id);
	}

	@Override
	public List<BloodSerology> getBloodSerologyByPatientIdentifier(String identifier) {
		return bloodBankDao.getBloodSerologyByPatientIdentifier(identifier);
	}
}
