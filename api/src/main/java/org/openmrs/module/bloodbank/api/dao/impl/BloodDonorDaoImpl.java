package org.openmrs.module.bloodbank.api.dao.impl;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.openmrs.module.bloodbank.api.dao.BloodDonorDao;
import org.openmrs.module.bloodbank.api.model.BloodDonor;
import org.openmrs.module.bloodbank.api.model.BloodDonorPhysicalSuitability;
import org.openmrs.module.bloodbank.api.model.Questionnaire;
import org.openmrs.module.bloodbank.api.model.dto.PatientDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

public class BloodDonorDaoImpl implements BloodDonorDao {

	protected final Logger log = LoggerFactory.getLogger(BloodDonorDaoImpl.class);

	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<BloodDonor> getAllBloodDonors() {
		Criteria donor = getSession().createCriteria(BloodDonor.class);
		donor.add(Restrictions.eq("voided", Boolean.FALSE));
		donor.add(Restrictions.eq("status", 1));
		log.info("Donor List ::" + donor.list());
		return donor.list();
	}

	@Transactional
	@Override
	public BloodDonor saveDonorInfo(BloodDonor bloodDonor) {
		getSession().merge(bloodDonor);
		log.info("Blood Donor Info is saved Successfully :: " + bloodDonor);
		return bloodDonor;
	}

	@Override
	public boolean existsByQuestionnaireName(String question) {
		Criteria criteria = getSession().createCriteria(Questionnaire.class);
		criteria.add(Restrictions.eq("question", question));
		criteria.add(Restrictions.eq("status", 1));
		Questionnaire result = (Questionnaire) criteria.uniqueResult();
		return result != null;
	}

	@Transactional
	@Override
	public Questionnaire saveQuestionnaire(Questionnaire questionnaire) {
		getSession().persist(questionnaire);
		log.info("Question has been saved successfully..." + questionnaire);
		return questionnaire;
	}

	@Override
	public List<Questionnaire> getAllQuestionnaires() {
		Criteria criteria = getSession().createCriteria(Questionnaire.class);
		criteria.add(Restrictions.eq("voided", Boolean.FALSE));
		criteria.add(Restrictions.eq("status", 1));
		log.info("Questionnaire List ::" + criteria.list());
		return criteria.list();
	}

	@Override
	@Transactional
	public Questionnaire getQuestionnaireById(Integer qid) {
		Criteria criteria = getSession().createCriteria(Questionnaire.class);
		criteria.add(Restrictions.eq("qid", qid));
		Questionnaire questionnaire = (Questionnaire) criteria.uniqueResult();
		return questionnaire;
	}

	@Override
	@Transactional
	public Questionnaire updateQuestionnaire(Questionnaire questionnaire) {
		getSession().update(questionnaire);
		log.info("Question has been updated successfully..." + questionnaire);
		return questionnaire;
	}

	@Override
	@Transactional
	public BloodDonor updateDonorInfo(BloodDonor bloodDonor) {
		getSession().update(bloodDonor);
		log.info("Blood Donor has been updated successfully..." + bloodDonor);
		return bloodDonor;
	}

	@Override
	@Transactional
	public BloodDonorPhysicalSuitability updateBloodDonorPhysicalSuitability(
	        BloodDonorPhysicalSuitability donorPhysicalSuitability) {
		getSession().update(donorPhysicalSuitability);
		log.info("Blood Donor Physical Suitability test is updated successfully..." + donorPhysicalSuitability);
		return donorPhysicalSuitability;
	}

	@Transactional
	@Override
	public BloodDonorPhysicalSuitability saveBloodDonorPhysicalSuitability(
	        BloodDonorPhysicalSuitability donorPhysicalSuitability) {
		getSession().persist(donorPhysicalSuitability);
		log.info("Donor Physical Suitability has been saved successfully..." + donorPhysicalSuitability);
		return donorPhysicalSuitability;
	}

	@Override
	public List<BloodDonorPhysicalSuitability> getAllBloodDonorPhysicalSuitability() {
		Criteria criteria = getSession().createCriteria(BloodDonorPhysicalSuitability.class);
		criteria.add(Restrictions.eq("voided", Boolean.FALSE));
		criteria.add(Restrictions.eq("status", 1));
		log.info("Blood Donor Physical Suitability List ::" + criteria.list());
		return criteria.list();
	}

	@Override
	@Transactional
	public BloodDonorPhysicalSuitability getBloodDonorPhysicalSuitabilityById(Integer id) {
		Criteria criteria = getSession().createCriteria(BloodDonorPhysicalSuitability.class);
		criteria.add(Restrictions.eq("donorPhysicalSuitabilityId", id));
		BloodDonorPhysicalSuitability bloodDonorPhysicalSuitability = (BloodDonorPhysicalSuitability) criteria
		        .uniqueResult();
		return bloodDonorPhysicalSuitability;
	}

	@Override
	@Transactional
	public BloodDonor getDonorById(Integer id) {
		Criteria criteria = getSession().createCriteria(BloodDonor.class);
		criteria.add(Restrictions.eq("donorId", id));
		BloodDonor bloodDonor = (BloodDonor) criteria.uniqueResult();
		return bloodDonor;
	}

	@Override
	public List<PatientDTO> getAllPatients() {
		String query = "SELECT DISTINCT v.patient_id, pi.identifier, p.uuid,\n"
		        + "                CONCAT(pn.given_name, ' ', IFNULL(pn.family_name, '')) AS name\n" + "FROM visit v\n"
		        + "         JOIN person_name pn ON v.patient_id = pn.person_id AND pn.voided = 0\n"
		        + "         JOIN patient_identifier pi ON v.patient_id = pi.patient_id\n"
		        + "         JOIN person p ON p.person_id = v.patient_id AND p.voided = 0\n"
		        + "WHERE v.date_stopped IS NULL\n" + "  AND v.voided = 0";
		SQLQuery sqlQuery = (SQLQuery) getSession().createSQLQuery(query).setResultTransformer(
		    Transformers.aliasToBean(PatientDTO.class));
		List<PatientDTO> patientList = sqlQuery.list();
		return patientList;
	}
}
