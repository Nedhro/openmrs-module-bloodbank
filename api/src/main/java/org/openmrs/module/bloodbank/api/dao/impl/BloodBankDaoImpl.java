package org.openmrs.module.bloodbank.api.dao.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.openmrs.module.bloodbank.api.dao.BloodBankDao;
import org.openmrs.module.bloodbank.api.model.BloodCompatibility;
import org.openmrs.module.bloodbank.api.model.BloodDonorPhysicalSuitability;
import org.openmrs.module.bloodbank.api.model.BloodStockTracing;
import org.openmrs.module.bloodbank.api.model.enums.PermissionType;
import org.openmrs.module.bloodbank.api.model.enums.SourceOfBlood;
import org.openmrs.module.bloodbank.api.model.enums.StockStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

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
		criteria.add(Restrictions.eq("voided", Boolean.FALSE));
		criteria.add(Restrictions.eq("donorSelection", PermissionType.Selected));
		return criteria.list();
	}

	@Override
	@Transactional
	public BloodCompatibility saveBloodCompatibility(BloodCompatibility bloodCompatibility) {
		if (bloodCompatibility.getCreatedBy() != null) {
			getSession().persist(bloodCompatibility);
			log.info("Blood compatibility has been saved successfully..." + bloodCompatibility);
			return bloodCompatibility;
		}
		log.info("No valid user found to create the Blood Compatibility Test");
		return null;
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
		criteria.add(Restrictions.eq("voided", Boolean.FALSE));
		criteria.add(Restrictions.between("dateCreated", getDateBefore30Days(), new Date()));
		log.info("Blood Compatibility List ::" + criteria.list());
		return criteria.list();
	}

	@Override
	@Transactional
	public BloodCompatibility getBloodCompatibilityById(Integer id) {
		Criteria criteria = getSession().createCriteria(BloodCompatibility.class);
		criteria.add(Restrictions.eq("bloodCompatibilityId", id));
    return (BloodCompatibility) criteria.uniqueResult();
	}

	@Override
	public BloodStockTracing saveBloodStockTracing(BloodStockTracing bloodStockTracing) {
		if (uniqueBloodBagId(bloodStockTracing.getBloodBagId())) {
			getSession().persist(bloodStockTracing);
			log.info("Blood Stock Tracing info has been saved successfully..." + bloodStockTracing);
			return bloodStockTracing;
		} else {
			return null;
		}
	}

	@Override
	public BloodStockTracing updateBloodStockTracing(BloodStockTracing bloodStockTracing) {
		bloodStockTracing.setDateChanged(new Date());
		getSession().update(bloodStockTracing);
		log.info("Blood Stock Tracing info has been updated successfully..." + bloodStockTracing);
		return bloodStockTracing;
	}

	@Override
	public List<BloodStockTracing> getAllBloodStockTracing() {
		Criteria criteria = getSession().createCriteria(BloodStockTracing.class);
		criteria.add(Restrictions.eq("status", 1));
		criteria.add(Restrictions.eq("voided", Boolean.FALSE));
		criteria.add(Restrictions.eq("stockStatus", StockStatus.Available));
		log.info("Blood Stock Tracing List ::" + criteria.list());
		return criteria.list();
	}

	@Override
	public BloodStockTracing getBloodStockTracingById(Integer id) {
		Criteria criteria = getSession().createCriteria(BloodStockTracing.class);
		criteria.add(Restrictions.eq("bloodStockTracingId", id));
    return (BloodStockTracing) criteria.uniqueResult();
	}

	@Override
	public BloodStockTracing getBloodStockTracingByBloodBagId(String bloodBagId) {
		Criteria criteria = getSession().createCriteria(BloodStockTracing.class);
		criteria.add(Restrictions.eq("bloodBagId", bloodBagId));
    return (BloodStockTracing) criteria.uniqueResult();
	}

	@Override
	public BloodCompatibility getCompatibilityByBagId(String bloodBagId) {
		Criteria criteria = getSession().createCriteria(BloodCompatibility.class);
		criteria.add(Restrictions.eq("bloodBagId", bloodBagId));
		criteria.add(Restrictions.eq("voided", Boolean.FALSE));
		criteria.add(Restrictions.eq("status", 1));
    return (BloodCompatibility) criteria.uniqueResult();
	}

	@Override
	public String getNextBloodBagId(String bloodSource) {
		SourceOfBlood sourceOfBlood;
		String initialValue;
		String prefix = "";
		switch (bloodSource) {
			case "NITOR":
				sourceOfBlood = SourceOfBlood.NITOR;
				prefix = "NTR";
				break;
			case "OutdoorCampaign":
				sourceOfBlood = SourceOfBlood.OutdoorCampaign;
				prefix = "CAM";
				break;
			default:
				sourceOfBlood = SourceOfBlood.Outsource;
		}
		Criteria criteria = getSession().createCriteria(BloodStockTracing.class);
		criteria.add(Restrictions.eq("sourceOfBlood", sourceOfBlood));
		criteria.addOrder(Order.desc("bloodBagId"));
		criteria.setMaxResults(1);
		List<BloodStockTracing> tracing = criteria.list();
		if (tracing.size() > 0) {
			int nextId = Integer.parseInt(tracing.get(0).getBloodBagId().trim().substring(3));
			nextId = nextId + 1;
			log.info("Next Blood Bag Id :: " + nextId);
			if (String.valueOf(nextId).length() > 3)
				return prefix.concat(String.valueOf(nextId));
			return prefix.concat(StringUtils.leftPad(String.valueOf(nextId), 3, "0"));
		}
		initialValue = prefix.concat("001");
		log.info("No Blood Bag Id. Initial Value :: " + initialValue);
		return initialValue;
	}

	public Boolean uniqueBloodBagId(String bloodBagId) {
		Criteria criteria = getSession().createCriteria(BloodStockTracing.class);
		criteria.add(Restrictions.eq("bloodBagId", bloodBagId));
		criteria.add(Restrictions.eq("status", 1));
		criteria.add(Restrictions.eq("voided", Boolean.FALSE));
		criteria.add(Restrictions.eq("stockStatus", StockStatus.Available));
		BloodStockTracing bloodStockTracing = (BloodStockTracing) criteria.uniqueResult();
		return bloodStockTracing == null;
	}

	public Date getDateBefore30Days() {
		Date currentDate = new Date();

		Calendar c = Calendar.getInstance();
		c.setTime(currentDate);
		c.add(Calendar.DATE, -30);

		Date dateBefore30Days = c.getTime();
		return dateBefore30Days;
	}
}
