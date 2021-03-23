package org.openmrs.module.bloodbank.api.service.impl;

import org.openmrs.api.APIException;
import org.openmrs.api.impl.BaseOpenmrsService;
import org.openmrs.module.bloodbank.api.dao.BloodDonorDao;
import org.openmrs.module.bloodbank.api.model.BloodDonor;
import org.openmrs.module.bloodbank.api.model.BloodDonorPhysicalSuitability;
import org.openmrs.module.bloodbank.api.model.Questionnaire;
import org.openmrs.module.bloodbank.api.service.BloodDonorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class BloodDonorServiceImpl extends BaseOpenmrsService implements BloodDonorService {
	
	protected final Logger log = LoggerFactory.getLogger(BloodDonorServiceImpl.class);
	
	private BloodDonorDao bloodDonorDao;
	
	public void setBloodDonorDao(BloodDonorDao bloodDonorDao) {
		this.bloodDonorDao = bloodDonorDao;
	}
	
	@Override
	public List<BloodDonor> getAllBloodDonors() {
		return bloodDonorDao.getAllBloodDonors();
	}
	
	@Override
	public BloodDonor saveDonorInfo(BloodDonor bloodDonor) {
		return bloodDonorDao.saveDonorInfo(bloodDonor);
	}
	
	@Override
	public Questionnaire saveQuestionnaire(Questionnaire questionnaire) {
		Boolean exists = this.existsByQuestionnaireName(questionnaire.getQuestion());
		if (exists == true) {
			log.info("This question is already in the questionnaire list...");
			return null;
		} else {
			return bloodDonorDao.saveQuestionnaire(questionnaire);
		}
	}
	
	@Override
	public List<Questionnaire> getAllQuestionnaires() {
		return bloodDonorDao.getAllQuestionnaires();
	}
	
	public boolean existsByQuestionnaireName(String question) {
		return bloodDonorDao.existsByQuestionnaireName(question);
	}
	
	@Override
	public BloodDonorPhysicalSuitability saveBloodDonorPhysicalSuitability(
	        BloodDonorPhysicalSuitability donorPhysicalSuitability) {
		return bloodDonorDao.saveBloodDonorPhysicalSuitability(donorPhysicalSuitability);
	}
	
	@Override
	public List<BloodDonorPhysicalSuitability> getAllBloodDonorPhysicalSuitability() {
		return bloodDonorDao.getAllBloodDonorPhysicalSuitability();
	}
	
}
