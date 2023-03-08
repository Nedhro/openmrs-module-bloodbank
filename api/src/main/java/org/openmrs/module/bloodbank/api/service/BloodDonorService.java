package org.openmrs.module.bloodbank.api.service;

import java.util.List;
import org.openmrs.api.APIException;
import org.openmrs.api.OpenmrsService;
import org.openmrs.module.bloodbank.api.model.BloodDonor;
import org.openmrs.module.bloodbank.api.model.BloodDonorPhysicalSuitability;
import org.openmrs.module.bloodbank.api.model.Questionnaire;
import org.openmrs.module.bloodbank.api.model.dto.PatientDTO;
import org.springframework.transaction.annotation.Transactional;

public interface BloodDonorService extends OpenmrsService {

	@Transactional
	BloodDonor saveDonorInfo(BloodDonor bloodDonor) throws APIException;

	@Transactional(readOnly = true)
	List<BloodDonor> getAllBloodDonors();

	boolean existsByQuestionnaireName(String question);

	@Transactional
	Questionnaire saveQuestionnaire(Questionnaire questionnaire) throws APIException;

	@Transactional(readOnly = true)
	List<Questionnaire> getAllQuestionnaires();

	@Transactional
	BloodDonorPhysicalSuitability saveBloodDonorPhysicalSuitability(
			BloodDonorPhysicalSuitability donorPhysicalSuitability)
			throws APIException;

	@Transactional(readOnly = true)
	List<BloodDonorPhysicalSuitability> getAllBloodDonorPhysicalSuitability();

	@Transactional(readOnly = true)
	Questionnaire getQuestionnaireById(Integer qid);

	BloodDonorPhysicalSuitability getBloodDonorPhysicalSuitabilityById(Integer id);

	BloodDonor getDonorById(Integer id);

	@Transactional
	Questionnaire updateQuestionnaire(Questionnaire questionnaire);

	@Transactional
	BloodDonor updateDonorInfo(BloodDonor bloodDonor);

	@Transactional
	BloodDonorPhysicalSuitability updateBloodDonorPhysicalSuitability(BloodDonorPhysicalSuitability donorPhysicalSuitability);

	List<PatientDTO> getAllPatients(Integer id);

	List<PatientDTO> getPatientById(String identifier);
}
