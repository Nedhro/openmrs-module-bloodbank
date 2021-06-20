package org.openmrs.module.bloodbank.api.dao;

import org.openmrs.module.bloodbank.api.model.BloodDonor;
import org.openmrs.module.bloodbank.api.model.BloodDonorPhysicalSuitability;
import org.openmrs.module.bloodbank.api.model.Questionnaire;

import java.util.List;

public interface BloodDonorDao {
	
	List<BloodDonor> getAllBloodDonors();
	
	BloodDonor saveDonorInfo(BloodDonor bloodDonor);
	
	boolean existsByQuestionnaireName(String question);
	
	Questionnaire saveQuestionnaire(Questionnaire questionnaire);
	
	List<Questionnaire> getAllQuestionnaires();
	
	BloodDonorPhysicalSuitability saveBloodDonorPhysicalSuitability(BloodDonorPhysicalSuitability donorPhysicalSuitability);
	
	List<BloodDonorPhysicalSuitability> getAllBloodDonorPhysicalSuitability();
	
	Questionnaire getQuestionnaireById(Integer qid);
	
	Questionnaire updateQuestionnaire(Questionnaire questionnaire);
	
	BloodDonor updateDonorInfo(BloodDonor bloodDonor);
	
	BloodDonorPhysicalSuitability updateBloodDonorPhysicalSuitability(BloodDonorPhysicalSuitability donorPhysicalSuitability);
	
	BloodDonorPhysicalSuitability getBloodDonorPhysicalSuitabilityById(Integer id);
	
	BloodDonor getDonorById(Integer id);
}
