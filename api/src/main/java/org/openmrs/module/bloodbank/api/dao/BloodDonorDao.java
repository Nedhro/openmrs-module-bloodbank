package org.openmrs.module.bloodbank.api.dao;

import java.util.List;
import org.openmrs.module.bloodbank.api.model.BloodDonor;
import org.openmrs.module.bloodbank.api.model.BloodDonorPhysicalSuitability;
import org.openmrs.module.bloodbank.api.model.Questionnaire;
import org.openmrs.module.bloodbank.api.model.dto.PatientDTO;

public interface BloodDonorDao {

	List<BloodDonor> getAllBloodDonors();

	BloodDonor saveDonorInfo(BloodDonor bloodDonor);

	boolean existsByQuestionnaireName(String question);

	Questionnaire saveQuestionnaire(Questionnaire questionnaire);

	List<Questionnaire> getAllQuestionnaires();

	BloodDonorPhysicalSuitability saveBloodDonorPhysicalSuitability(
			BloodDonorPhysicalSuitability donorPhysicalSuitability);

	List<BloodDonorPhysicalSuitability> getAllBloodDonorPhysicalSuitability();

	Questionnaire getQuestionnaireById(Integer qid);

	Questionnaire updateQuestionnaire(Questionnaire questionnaire);

	BloodDonor updateDonorInfo(BloodDonor bloodDonor);

	BloodDonorPhysicalSuitability updateBloodDonorPhysicalSuitability(
			BloodDonorPhysicalSuitability donorPhysicalSuitability);

	BloodDonorPhysicalSuitability getBloodDonorPhysicalSuitabilityById(Integer id);

	BloodDonor getDonorById(Integer id);

	List<PatientDTO> getAllPatients(Integer id);

	List<PatientDTO> getPatientById(String identifier);
}
