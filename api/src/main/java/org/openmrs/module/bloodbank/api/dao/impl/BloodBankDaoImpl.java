package org.openmrs.module.bloodbank.api.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.openmrs.module.bloodbank.api.dao.BloodBankDao;
import org.openmrs.module.bloodbank.api.model.BloodCompatibility;
import org.openmrs.module.bloodbank.api.model.BloodDonorPhysicalSuitability;
import org.openmrs.module.bloodbank.api.model.Questionnaire;
import org.openmrs.module.bloodbank.api.model.enums.PermissionType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import sun.rmi.runtime.Log;

import java.util.List;

public class BloodBankDaoImpl implements BloodBankDao {
	
	protected final Logger log = LoggerFactory.getLogger(BloodDonorDaoImpl.class);
	
	private SessionFactory sessionFactory;
	
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public List<BloodDonorPhysicalSuitability> getAllDonorTestsResult() {
		Criteria criteria = getSession().createCriteria(BloodDonorPhysicalSuitability.class);
		criteria.add(Restrictions.eq("donorSelection", PermissionType.Selected));
		return criteria.list();
	}
	
	@Override
	@Transactional
	public BloodCompatibility saveBloodDonorPhysicalSuitability(BloodCompatibility bloodCompatibility) {
		getSession().persist(bloodCompatibility);
		log.info("Blood compatibility has been saved successfully..." + bloodCompatibility);
		return bloodCompatibility;
	}
	
	@Override
	@Transactional
	public BloodCompatibility updateBloodCompatibility(BloodCompatibility bloodCompatibility) {
		getSession().update(bloodCompatibility);
		log.info("Blood compatibility has been updated successfully..." + bloodCompatibility);
		return bloodCompatibility;
	}
	
	@Override
	public List<BloodCompatibility> getAllBloodCompatibility() {
		Criteria criteria = getSession().createCriteria(BloodCompatibility.class);
		criteria.add(Restrictions.eq("status", 1));
		log.info("Blood Compatibility List ::" + criteria.list());
		return criteria.list();
	}
	
	@Override
	@Transactional
	public BloodCompatibility getBloodCompatibilityById(Integer id) {
		Criteria criteria = getSession().createCriteria(BloodCompatibility.class);
		criteria.add((Restrictions.eq("bloodCompatibilityId", id)));
		BloodCompatibility compatibility = (BloodCompatibility) criteria.uniqueResult();
		return compatibility;
	}
}
