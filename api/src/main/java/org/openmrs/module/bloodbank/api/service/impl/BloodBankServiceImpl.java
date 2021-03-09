package org.openmrs.module.bloodbank.api.service.impl;

import org.openmrs.api.impl.BaseOpenmrsService;
import org.openmrs.module.bloodbank.api.service.BloodBankService;
import org.openmrs.module.bloodbank.api.dao.BloodBankDao;

public class BloodBankServiceImpl extends BaseOpenmrsService implements BloodBankService {
	
	private BloodBankDao bloodBankDao;
	
	//	private UserService userService;
	
	public void setBloodBankDao(BloodBankDao bloodBankDao) {
		this.bloodBankDao = bloodBankDao;
	}
	
	/*public void setUserService(UserService userService) {
		this.userService = userService;
	}*/
	
}
