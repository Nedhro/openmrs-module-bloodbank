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
	
	private List<PatientDTO> patientList;
	
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
		Integer id = (Integer) getSession().save(bloodDonor);
		bloodDonor.setDonorId(id);
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
	public List<PatientDTO> getAllPatients(Integer id) {
		String query = "select DISTINCT p.patient_id,\n"
				+ "                per.uuid,\n"
				+ "                CONCAT(IF(pn.given_name IS NULL, '', CONCAT((pn.given_name), ' ')),\n"
				+ "                       IF(pn.middle_name IS NULL, '', CONCAT((pn.middle_name), ' ')),\n"
				+ "                       IF(pn.family_name IS NULL, '', CONCAT((pn.family_name), ' ')),\n"
				+ "                       '(', pi.identifier, ')') AS 'name',\n"
				+ "                CONCAT(IF(TIMESTAMPDIFF(YEAR, per.birthdate, now()) = 0, '',\n"
				+ "                          CONCAT((CONCAT(TIMESTAMPDIFF(YEAR, per.birthdate, now()), 'Y')), ' ')),\n"
				+ "                       IF((TIMESTAMPDIFF(MONTH, per.birthdate, now()) % 12) = 0, '',\n"
				+ "                          CONCAT((CONCAT((TIMESTAMPDIFF(MONTH, per.birthdate, now()) % 12), 'M')), ' ')),\n"
				+ "                       IF(FLOOR(TIMESTAMPDIFF(DAY, per.birthdate, now()) % 30.4375) = 0, '',\n"
				+ "                          CONCAT((CONCAT(FLOOR(TIMESTAMPDIFF(DAY, per.birthdate, now()) % 30.4375), 'D')), ' '))\n"
				+ "                    )                           AS 'age',\n"
				+ "                per.gender                      as 'gender',\n"
				+ "                bed.Bed                         as 'bed',\n"
				+ "                bed.ward                        as 'ward',\n"
				+ "                bed.unit                        as 'unit'\n"
				+ "from patient p\n"
				+ "         inner join patient_identifier pi on p.patient_id = pi.patient_id\n"
				+ "         inner join person per on p.patient_id = per.person_id\n"
				+ "         inner join person_name pn on p.patient_id = pn.person_id\n"
				+ "         left join (SELECT bed_patient_assignment_map_id, bed_id, patient_id\n"
				+ "                    FROM bed_patient_assignment_map\n"
				+ "                    WHERE bed_patient_assignment_map_id IN (\n"
				+ "                        SELECT MAX(bed_patient_assignment_map_id)\n"
				+ "                        FROM bed_patient_assignment_map\n"
				+ "                        GROUP BY patient_id)) latest on p.patient_id = latest.patient_id\n"
				+ "         left join (SELECT floor.name     as 'ward',\n"
				+ "                           bed.bed_number as 'bed',\n"
				+ "                           btag.name      as 'unit',\n"
				+ "                           bed.bed_id     as 'id'\n"
				+ "                    from bed\n"
				+ "                             inner join bed_location_map on bed.bed_id = bed_location_map.bed_id\n"
				+ "                             inner join location as ward on bed_location_map.location_id = ward.location_id\n"
				+ "                             inner join location as floor on ward.parent_location = floor.location_id\n"
				+ "                             left join bed_tag_map btagmap on bed.bed_id = btagmap.bed_id\n"
				+ "                             left join bed_tag btag on btagmap.bed_tag_id = btag.bed_tag_id) bed\n"
				+ "                   on latest.bed_id = bed.id\n" + "where p.patient_id = " + id + "";
		SQLQuery sqlQuery = (SQLQuery) getSession().createSQLQuery(query).setResultTransformer(
				Transformers.aliasToBean(PatientDTO.class));
		List<PatientDTO> patientList = sqlQuery.list();
		return patientList;
	}

	@Override
	public List<PatientDTO> getPatientById(String identifier) {
		String query = "select DISTINCT p.patient_id,\n"
				+ "                CONCAT(IF(pn.given_name IS NULL, '', CONCAT((pn.given_name), ' ')),\n"
				+ "                       IF(pn.middle_name IS NULL, '', CONCAT((pn.middle_name), ' ')),\n"
				+ "                       IF(pn.family_name IS NULL, '', CONCAT((pn.family_name), ' ')),\n"
				+ "                       '(', pi.identifier, ')') AS 'name'\n" + "from patient p\n"
				+ "         inner join patient_identifier pi on p.patient_id = pi.patient_id\n"
				+ "         inner join person_name pn on p.patient_id = pn.person_id\n"
				+ "where pi.identifier =  '"
				+ identifier + "'";
		SQLQuery sqlQuery = (SQLQuery) getSession().createSQLQuery(query).setResultTransformer(
				Transformers.aliasToBean(PatientDTO.class));
		List<PatientDTO> patientList = sqlQuery.list();
		return patientList;
	}

}
