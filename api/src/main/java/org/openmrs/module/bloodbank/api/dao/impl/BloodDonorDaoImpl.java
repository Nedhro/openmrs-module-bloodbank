package org.openmrs.module.bloodbank.api.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.openmrs.module.bloodbank.api.dao.BloodDonorDao;
import org.openmrs.module.bloodbank.api.model.BloodDonor;
import org.openmrs.module.bloodbank.api.model.BloodDonorPhysicalSuitability;
import org.openmrs.module.bloodbank.api.model.Questionnaire;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
		//		List<BloodDonor> donorList = getSession().createQuery("from BloodDonor").list();
		System.out.println("Donor List ::" + donor.list());
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
		Questionnaire result = (Questionnaire) criteria.uniqueResult();
		if (result == null) {
			return false;
		} else {
			return true;
		}
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
		System.out.println("Questionnaire List ::" + criteria.list());
		log.info("Questionnaire List ::" + criteria.list());
		return criteria.list();
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
		System.out.println("Blood Donor Physical Suitability List ::" + criteria.list());
		log.info("Blood Donor Physical Suitability List ::" + criteria.list());
		return criteria.list();
	}
	
}
