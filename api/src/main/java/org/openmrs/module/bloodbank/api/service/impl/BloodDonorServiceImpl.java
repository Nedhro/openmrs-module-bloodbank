package org.openmrs.module.bloodbank.api.service.impl;

import java.util.List;
import org.openmrs.api.impl.BaseOpenmrsService;
import org.openmrs.module.bloodbank.api.dao.BloodDonorDao;
import org.openmrs.module.bloodbank.api.model.BloodDonor;
import org.openmrs.module.bloodbank.api.model.BloodDonorPhysicalSuitability;
import org.openmrs.module.bloodbank.api.model.Questionnaire;
import org.openmrs.module.bloodbank.api.model.dto.PatientDTO;
import org.openmrs.module.bloodbank.api.service.BloodDonorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

	@Override
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
	
	@Override
	public Questionnaire getQuestionnaireById(Integer qid) {
		return bloodDonorDao.getQuestionnaireById(qid);
	}
	
	@Override
	public BloodDonorPhysicalSuitability getBloodDonorPhysicalSuitabilityById(Integer id) {
		return bloodDonorDao.getBloodDonorPhysicalSuitabilityById(id);
	}
	
	@Override
	public BloodDonor getDonorById(Integer id) {
		return bloodDonorDao.getDonorById(id);
	}

	@Override
	public Questionnaire updateQuestionnaire(Questionnaire questionnaire) {
		return bloodDonorDao.updateQuestionnaire(questionnaire);
	}

	@Override
	public BloodDonor updateDonorInfo(BloodDonor bloodDonor) {
		return bloodDonorDao.updateDonorInfo(bloodDonor);
	}

	@Override
	public BloodDonorPhysicalSuitability updateBloodDonorPhysicalSuitability(
			BloodDonorPhysicalSuitability donorPhysicalSuitability) {
		return bloodDonorDao.updateBloodDonorPhysicalSuitability(donorPhysicalSuitability);
	}

	@Override
	public List<PatientDTO> getAllPatients(Integer id) {
		return bloodDonorDao.getAllPatients(id);
	}

	@Override
	public List<PatientDTO> getPatientById(String identifier) {
		return bloodDonorDao.getPatientById(identifier);
	}
}
