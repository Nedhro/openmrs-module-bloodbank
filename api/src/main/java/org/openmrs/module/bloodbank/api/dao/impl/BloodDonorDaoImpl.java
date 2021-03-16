package org.openmrs.module.bloodbank.api.dao.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.openmrs.module.bloodbank.api.dao.BloodDonorDao;
import org.openmrs.module.bloodbank.api.model.BloodDonor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

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
		List<BloodDonor> donorList = getSession().createQuery("from BloodDonor").list();
		System.out.println("Donor List ::" + donorList);
		log.info("Donor List ::" + donorList);
		return donorList;
	}
}
