package org.openmrs.module.bloodbank.api.service;

import org.openmrs.api.APIException;
import org.openmrs.api.OpenmrsService;
import org.openmrs.module.bloodbank.api.model.BloodDonor;
import org.openmrs.module.bloodbank.api.model.Questionnaire;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BloodDonorService extends OpenmrsService {
	
	@Transactional
	BloodDonor saveDonorInfo(BloodDonor bloodDonor) throws APIException;
	
	@Transactional(readOnly = true)
	List<BloodDonor> getAllBloodDonors();
	
	@Transactional
	Questionnaire saveQuestionnaire(Questionnaire questionnaire) throws APIException;
	
	@Transactional(readOnly = true)
	List<Questionnaire> getAllQuestionnaires();
}
