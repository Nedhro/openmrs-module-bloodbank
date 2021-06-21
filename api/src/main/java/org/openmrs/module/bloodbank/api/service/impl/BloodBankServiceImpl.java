package org.openmrs.module.bloodbank.api.service.impl;

import org.openmrs.api.UserService;
import org.openmrs.api.impl.BaseOpenmrsService;
import org.openmrs.module.bloodbank.api.dao.BloodBankDao;
import org.openmrs.module.bloodbank.api.model.BloodDonorPhysicalSuitability;
import org.openmrs.module.bloodbank.api.service.BloodBankService;

import java.util.List;

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
}
