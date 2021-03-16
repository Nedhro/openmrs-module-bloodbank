package org.openmrs.module.bloodbank.api.service.impl;

import org.openmrs.api.impl.BaseOpenmrsService;
import org.openmrs.module.bloodbank.api.dao.BloodDonorDao;
import org.openmrs.module.bloodbank.api.model.BloodDonor;
import org.openmrs.module.bloodbank.api.service.BloodDonorService;

import java.util.List;

public class BloodDonorServiceImpl extends BaseOpenmrsService implements BloodDonorService {
	
	private BloodDonorDao bloodDonorDao;
	
	public void setBloodDonorDao(BloodDonorDao bloodDonorDao) {
		this.bloodDonorDao = bloodDonorDao;
	}
	
	@Override
	public List<BloodDonor> getAllBloodDonors() {
		return bloodDonorDao.getAllBloodDonors();
	}
}
