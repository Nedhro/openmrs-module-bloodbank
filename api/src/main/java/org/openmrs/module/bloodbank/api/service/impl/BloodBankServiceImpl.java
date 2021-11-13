package org.openmrs.module.bloodbank.api.service.impl;

import java.util.List;
import org.openmrs.api.UserService;
import org.openmrs.api.impl.BaseOpenmrsService;
import org.openmrs.module.bloodbank.api.dao.BloodBankDao;
import org.openmrs.module.bloodbank.api.model.BloodCompatibility;
import org.openmrs.module.bloodbank.api.model.BloodDonorPhysicalSuitability;
import org.openmrs.module.bloodbank.api.model.BloodStockTracing;
import org.openmrs.module.bloodbank.api.service.BloodBankService;

public class BloodBankServiceImpl extends BaseOpenmrsService implements BloodBankService {

  private BloodBankDao bloodBankDao;

  private UserService userService;

  public void setBloodBankDao(BloodBankDao bloodBankDao) {
    this.bloodBankDao = bloodBankDao;
  }

  public void setUserService(UserService userService) {
    this.userService = userService;
  }

  @Override
  public List<BloodDonorPhysicalSuitability> getAllDonorTestsResult() {
    return bloodBankDao.getAllDonorTestsResult();
  }

  @Override
  public BloodCompatibility saveBloodCompatibility(BloodCompatibility bloodCompatibility) {
    return bloodBankDao.saveBloodCompatibility(bloodCompatibility);
  }

  @Override
  public BloodCompatibility updateBloodCompatibility(BloodCompatibility bloodCompatibility) {
    return bloodBankDao.updateBloodCompatibility(bloodCompatibility);
  }

  @Override
  public List<BloodCompatibility> getAllBloodCompatibility() {
    return bloodBankDao.getAllBloodCompatibility();
  }

  @Override
  public BloodCompatibility getBloodCompatibilityById(Integer id) {
    return bloodBankDao.getBloodCompatibilityById(id);
  }

  @Override
  public BloodStockTracing saveBloodStockTracing(BloodStockTracing bloodStockTracing) {
    return bloodBankDao.saveBloodStockTracing(bloodStockTracing);
  }

  @Override
  public BloodStockTracing updateBloodStockTracing(BloodStockTracing bloodStockTracing) {
    return bloodBankDao.updateBloodStockTracing(bloodStockTracing);
  }

  @Override
  public List<BloodStockTracing> getAllBloodStockTracing() {
    return bloodBankDao.getAllBloodStockTracing();
  }

  @Override
  public BloodStockTracing getBloodStockTracingById(Integer id) {
    return bloodBankDao.getBloodStockTracingById(id);
  }

  @Override
  public BloodStockTracing getBloodStockTracingByBloodBagId(String bloodBagId) {
    return bloodBankDao.getBloodStockTracingByBloodBagId(bloodBagId);
  }

  @Override
  public BloodCompatibility getCompatibilityByBagId(String bloodBagId) {
    return bloodBankDao.getCompatibilityByBagId(bloodBagId);
  }

  @Override
  public String getNextBloodBagId(String bloodSource) {
    return bloodBankDao.getNextBloodBagId(bloodSource);
  }
}
