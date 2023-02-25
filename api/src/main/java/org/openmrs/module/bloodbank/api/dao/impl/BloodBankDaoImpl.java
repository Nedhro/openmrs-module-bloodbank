package org.openmrs.module.bloodbank.api.dao.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.openmrs.GlobalProperty;
import org.openmrs.module.bloodbank.api.dao.BloodBankDao;
import org.openmrs.module.bloodbank.api.model.BloodCompatibility;
import org.openmrs.module.bloodbank.api.model.BloodDonorPhysicalSuitability;
import org.openmrs.module.bloodbank.api.model.BloodSerology;
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
    BloodCompatibility compatibility = (BloodCompatibility) criteria.uniqueResult();
    return compatibility;
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
    criteria.add(Restrictions.eq("stockStatus", StockStatus.Available.getValue()));
    log.info("Blood Stock Tracing List ::" + criteria.list());
    return criteria.list();
  }

  @Override
  public List<BloodStockTracing> getAllBloodStockTracingApproved() {
    Criteria criteria = getSession().createCriteria(BloodStockTracing.class);
    criteria.add(Restrictions.eq("status", 2));
    criteria.add(Restrictions.eq("voided", Boolean.TRUE));
    criteria.add(Restrictions.eq("stockStatus", StockStatus.NotAvailable.getValue()));
    log.info("Blood Stock Tracing List ::" + criteria.list());
    return criteria.list();
  }

  @Override
  public BloodStockTracing getBloodStockTracingById(Integer id) {
    Criteria criteria = getSession().createCriteria(BloodStockTracing.class);
    criteria.add(Restrictions.eq("bloodStockTracingId", id));
    BloodStockTracing bloodStockTracing = (BloodStockTracing) criteria.uniqueResult();
    return bloodStockTracing;
  }

  @Override
  public BloodStockTracing getBloodStockTracingByBloodBagId(String bloodBagId) {
    Criteria criteria = getSession().createCriteria(BloodStockTracing.class);
    criteria.add(Restrictions.eq("bloodBagId", bloodBagId));
    BloodStockTracing bloodStockTracing = (BloodStockTracing) criteria.uniqueResult();
    return bloodStockTracing;
  }

  @Override
  public BloodCompatibility getCompatibilityByBagId(String bloodBagId) {
    Criteria criteria = getSession().createCriteria(BloodCompatibility.class);
    criteria.add(Restrictions.eq("bloodBagId", bloodBagId));
    criteria.add(Restrictions.eq("voided", Boolean.FALSE));
    criteria.add(Restrictions.eq("status", 1));
    BloodCompatibility bloodCompatibility = (BloodCompatibility) criteria.uniqueResult();
    return bloodCompatibility;
  }

  @Override
  public String getNextBloodBagId(String bloodSource) {
    Criteria nitorPrefixCriteria = getSession().createCriteria(GlobalProperty.class);
    nitorPrefixCriteria.add(Restrictions.eq("property", "bloodbank.bloodbag.id.prefix"));
    String nitorPrefix = ((GlobalProperty) nitorPrefixCriteria.uniqueResult()).getPropertyValue();
    String sourceOfBlood;
    String initialValue = "001";
    String prefix = "";
    String bloodBagId;
    String currentYear = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
    switch (bloodSource) {
      case "NITOR":
        sourceOfBlood = SourceOfBlood.NITOR.getValue();
        prefix = nitorPrefix;
        break;
      case "Outdoor Campaign":
        sourceOfBlood = SourceOfBlood.OutdoorCampaign.getValue();
        prefix = "CAM";
        break;
      default:
        sourceOfBlood = SourceOfBlood.Outsource.getValue();
    }

    Criteria criteria = getSession().createCriteria(BloodStockTracing.class);
    criteria.add(Restrictions.eq("sourceOfBlood", sourceOfBlood));
    criteria.addOrder(Order.desc("bloodStockTracingId"));
    criteria.setMaxResults(1);
    BloodStockTracing tracing = (BloodStockTracing) criteria.uniqueResult();
    if (tracing != null) {
      String previousId = tracing.getBloodBagId();
      if (previousId.contains("-")) {
        String lastIdYear = previousId.substring(prefix.length(), previousId.indexOf("-"));
        String newIndex = StringUtils.leftPad(
            String.valueOf(Integer.parseInt(previousId.split("-")[1]) + 1), 3, "0");
        if (Objects.equals(lastIdYear, currentYear)) {
          bloodBagId = prefix + currentYear + "-" + newIndex;
          return bloodBagId;
        }
      }
    }
    bloodBagId = prefix + currentYear + "-" + initialValue;
    return bloodBagId;
  }

  @Override
  @Transactional
  public BloodSerology saveBloodSerology(BloodSerology bloodSerology) {
    if (bloodSerology.getCreatedBy() != null) {
      getSession().persist(bloodSerology);
      log.info("Blood serology has been saved successfully..." + bloodSerology);
      return bloodSerology;
    }
    log.info("No valid user found to create the Blood serology Test");
    return null;
  }

  @Override
  @Transactional
  public BloodSerology updateBloodSerology(BloodSerology bloodSerology) {
    getSession().update(bloodSerology);
    log.info("Blood serology has been updated successfully..." + bloodSerology);
    return bloodSerology;
  }

  @Override
  public List<BloodSerology> getAllBloodSerology() {
    Criteria criteria = getSession().createCriteria(BloodSerology.class);
    criteria.add(Restrictions.eq("status", 1));
    criteria.add(Restrictions.eq("voided", Boolean.FALSE));
    criteria.add(Restrictions.between("dateCreated", getDateBefore30Days(), new Date()));
    log.info("Blood Serology List ::" + criteria.list());
    return criteria.list();
  }

  @Override
  @Transactional
  public BloodSerology getBloodSerologyById(Integer id) {
    Criteria criteria = getSession().createCriteria(BloodSerology.class);
    criteria.add(Restrictions.eq("bloodSerologyId", id));
    BloodSerology serology = (BloodSerology) criteria.uniqueResult();
    return serology;
  }

  @Override
  public BloodSerology getBloodSerologyByPatientId(Integer id) {
    Criteria criteria = getSession().createCriteria(BloodSerology.class);
    criteria.add(Restrictions.eq("patientId", id));
    criteria.add(Restrictions.ne("patientBloodGroup", ""));
    criteria.addOrder(Order.desc("bloodSerologyId"));
    criteria.setMaxResults(1);
    BloodSerology serology = (BloodSerology) criteria.uniqueResult();
    return serology;
  }

  @Override
  public List<BloodSerology> getBloodSerologyByPatientIdentifier(String identifier) {
    Criteria criteria = getSession().createCriteria(BloodSerology.class);
    criteria.add(Restrictions.like("patientName", identifier, MatchMode.ANYWHERE));
    criteria.addOrder(Order.desc("bloodSerologyId"));
    return criteria.list();
  }

  public Boolean uniqueBloodBagId(String bloodBagId) {
    Criteria criteria = getSession().createCriteria(BloodStockTracing.class);
    criteria.add(Restrictions.eq("bloodBagId", bloodBagId));
    criteria.add(Restrictions.eq("status", 1));
    criteria.add(Restrictions.eq("voided", Boolean.FALSE));
    criteria.add(Restrictions.eq("stockStatus", StockStatus.Available.getValue()));
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
