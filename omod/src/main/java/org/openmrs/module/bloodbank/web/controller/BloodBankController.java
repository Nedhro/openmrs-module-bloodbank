package org.openmrs.module.bloodbank.web.controller;

import java.util.List;
import javax.validation.Valid;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.module.bloodbank.api.model.BloodCompatibility;
import org.openmrs.module.bloodbank.api.model.BloodDonorPhysicalSuitability;
import org.openmrs.module.bloodbank.api.model.BloodSerology;
import org.openmrs.module.bloodbank.api.model.BloodStockTracing;
import org.openmrs.module.bloodbank.api.model.enums.Status;
import org.openmrs.module.bloodbank.api.model.enums.StockStatus;
import org.openmrs.module.bloodbank.api.service.BloodBankService;
import org.openmrs.module.webservices.rest.web.RestConstants;
import org.openmrs.module.webservices.rest.web.RestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/rest/" + RestConstants.VERSION_1 + "/bloodbank")
public class BloodBankController {
	
	private Log log = LogFactory.getLog(this.getClass());
	
	@Autowired
	private BloodBankService bloodBankService;
	
	@RequestMapping(method = RequestMethod.GET, value = "bloodSelectedFromDonor/list")
	@ResponseBody
	public List<BloodDonorPhysicalSuitability> getAllDonorTestsResult() {
		List<BloodDonorPhysicalSuitability> bloodDonorPhysicalSuitability = bloodBankService.getAllDonorTestsResult();
		log.info("Blood Donor Physical Suitability Test Lists :: " + bloodDonorPhysicalSuitability);
		return bloodDonorPhysicalSuitability;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "bloodCompatibilityTest/add")
    @ResponseBody
    public ResponseEntity<Object> saveBloodCompatibility(
            @Valid @RequestBody BloodCompatibility bloodCompatibility) {
        if (bloodCompatibility.getBloodCompatibilityId() == null) {
            if (bloodCompatibility.getCreatedBy() != null) {
                bloodBankService.saveBloodCompatibility(bloodCompatibility);
                log.info("Blood Compatibility is saved successfully :: " + bloodCompatibility);
                return new ResponseEntity<>(bloodCompatibility, HttpStatus.CREATED);
            }
            log.warn("No valid user found");
            return new ResponseEntity<>("No User found", HttpStatus.BAD_REQUEST);
        }
        if (bloodCompatibility.getUpdatedBy() != null) {
            bloodBankService.updateBloodCompatibility(bloodCompatibility);
            log.info("Blood Compatibility is updated successfully :: " + bloodCompatibility);
            return new ResponseEntity<>(bloodCompatibility, HttpStatus.ACCEPTED);
        }
        log.warn("No valid user found");
        return new ResponseEntity<>("No User found", HttpStatus.BAD_REQUEST);
    }
	
	@RequestMapping(method = RequestMethod.GET, value = "bloodCompatibilityTest/list")
	@ResponseBody
	public List<BloodCompatibility> getAllBloodCompatibility() {
		List<BloodCompatibility> bloodCompatibilities = bloodBankService.getAllBloodCompatibility();
		log.info("Blood Compatibility Lists :: " + bloodCompatibilities);
		return bloodCompatibilities;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "bloodCompatibilityTest/{id}")
    @ResponseBody
    public ResponseEntity<Object> getBloodCompatibilityById(@PathVariable Integer id) {
        try {
            if (id != null) {
                BloodCompatibility bloodCompatibility = bloodBankService.getBloodCompatibilityById(id);
                log.info("Blood Compatibility is retrieved successfully :: " + bloodCompatibility);
                return new ResponseEntity<>(bloodCompatibility, HttpStatus.OK);
            }
        } catch (Exception e) {
            log.error("Runtime error while trying to find the Blood Compatibility", e);
            return new ResponseEntity<>(
                    RestUtil.wrapErrorResponse(e, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
        return null;
    }
	
	@RequestMapping(
            method = RequestMethod.PUT,
            value = "bloodCompatibilityTest/delete/{id}/by/{user}")
    @ResponseBody
    public ResponseEntity<Object> deleteBloodCompatibilityById(
            @PathVariable Integer id, @PathVariable String user) {
        BloodCompatibility bloodCompatibility = bloodBankService.getBloodCompatibilityById(id);
        if (user != null && !user.equals("undefined")) {
            bloodCompatibility.setStatus(Status.DELETE.getValue());
            bloodCompatibility.setVoided(Boolean.TRUE);
            bloodCompatibility.setUpdatedBy(user);
            bloodBankService.updateBloodCompatibility(bloodCompatibility);
            log.info("Blood Compatibility is deleted successfully :: " + bloodCompatibility);
            return new ResponseEntity<>(bloodCompatibility, HttpStatus.ACCEPTED);
        }
        log.warn("No valid user found");
        return new ResponseEntity<>("No User found", HttpStatus.BAD_REQUEST);
    }
	
	@RequestMapping(method = RequestMethod.POST, value = "bloodStockTracing/add")
    @ResponseBody
    public ResponseEntity<Object> saveBloodStockTracing(
            @Valid @RequestBody BloodStockTracing bloodStockTracing) {
        if (bloodStockTracing.getBloodStockTracingId() == null) {
            if (bloodStockTracing.getCreatedBy() != null) {
                BloodStockTracing stockTracing = bloodBankService.saveBloodStockTracing(bloodStockTracing);
                if (stockTracing == null)
                    return new ResponseEntity<>(bloodStockTracing, HttpStatus.IM_USED);
                log.info("Blood Stock Tracing info is saved successfully :: " + bloodStockTracing);
                return new ResponseEntity<>(bloodStockTracing, HttpStatus.CREATED);
            }
            log.warn("No valid user found");
            return new ResponseEntity<>("No User found to add new", HttpStatus.BAD_REQUEST);
        }
      if (bloodStockTracing.getUpdatedBy() != null) {
          bloodBankService.updateBloodStockTracing(bloodStockTracing);
          log.info("Blood Stock Tracing info is updated successfully :: " + bloodStockTracing);
          return new ResponseEntity<>(bloodStockTracing, HttpStatus.ACCEPTED);
      }
      log.warn("No valid user found");
      return new ResponseEntity<>("No User found to update", HttpStatus.BAD_REQUEST);
  }

    @RequestMapping(method = RequestMethod.GET, value = "bloodStockTracing/list")
    @ResponseBody
    public List<BloodStockTracing> getAllBloodStockTracing() {
        List<BloodStockTracing> bloodStockTracings = bloodBankService.getAllBloodStockTracing();
        log.info("Blood Stock Tracing Lists :: " + bloodStockTracings);
        return bloodStockTracings;
    }

    @RequestMapping(method = RequestMethod.GET, value = "bloodStockTracing/approvedList")
    @ResponseBody
    public List<BloodStockTracing> getAllBloodStockTracingApproved() {
        List<BloodStockTracing> bloodStockTracings = bloodBankService.getAllBloodStockTracingApproved();
        log.info("Blood Stock Tracing Lists :: " + bloodStockTracings);
        return bloodStockTracings;
    }

    @RequestMapping(method = RequestMethod.GET, value = "bloodStockTracing/{id}")
    @ResponseBody
    public ResponseEntity<Object> getBloodStockTracingById(@PathVariable Integer id) {
        try {
            if (id != null) {
                BloodStockTracing bloodStockTracing = bloodBankService.getBloodStockTracingById(id);
                log.info(
                    "Blood Stock Tracing info is retrieved successfully :: " + bloodStockTracing);
                return new ResponseEntity<>(bloodStockTracing, HttpStatus.OK);
            }
        } catch (Exception e) {
            log.error("Runtime error while trying to find the Blood Stock Tracing", e);
            return new ResponseEntity<>(
                    RestUtil.wrapErrorResponse(e, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
        return null;
    }
	
	@RequestMapping(method = RequestMethod.PUT, value = "bloodStockTracing/delete/{id}/by/{user}")
    @ResponseBody
    public ResponseEntity<Object> deleteBloodStockTracingById(
            @PathVariable Integer id, @PathVariable String user) {
        if (user != null && !user.equals("undefined")) {
            BloodStockTracing bloodStockTracing = bloodBankService.getBloodStockTracingById(id);
            bloodStockTracing.setStatus(Status.DELETE.getValue());
            bloodStockTracing.setVoided(Boolean.TRUE);
            bloodStockTracing.setStockStatus(StockStatus.NotAvailable.getValue());
            bloodStockTracing.setUpdatedBy(user);
            bloodBankService.updateBloodStockTracing(bloodStockTracing);
            log.info("Blood Stock Tracing is deleted successfully :: " + bloodStockTracing);
            return new ResponseEntity<>(bloodStockTracing, HttpStatus.ACCEPTED);
        }
        log.warn("No valid user found");
        return new ResponseEntity<>("No User found", HttpStatus.BAD_REQUEST);
    }
	
	@RequestMapping(
            method = RequestMethod.GET,
            value = "bloodStockTracing/nextBloodBagId/{bloodSource}")
    @ResponseBody
    public ResponseEntity<Object> checkBloodBagID(@PathVariable String bloodSource) {
        String bagId = bloodBankService.getNextBloodBagId(bloodSource);
        if (bagId.isEmpty()) return new ResponseEntity<>(bagId, HttpStatus.BAD_REQUEST);
        log.info("Next Blood Bag Id:: " + bagId);
        return new ResponseEntity<>(bagId, HttpStatus.ACCEPTED);
    }
	
	@RequestMapping(
            method = RequestMethod.PUT,
            value = "bloodStockTracing/updateStatus/{bloodBagId}/by/{user}")
    @ResponseBody
    public ResponseEntity<Object> updateBloodStockTracingStatus(
            @PathVariable String bloodBagId, @PathVariable String user) {
        if (user != null && !user.equals("undefined")) {
            BloodStockTracing bloodStockTracing =
                    bloodBankService.getBloodStockTracingByBloodBagId(bloodBagId);
            if (bloodStockTracing != null) {
                if (bloodStockTracing.getStockStatus().equals(StockStatus.Available.getValue())) {
                    bloodStockTracing.setVoided(Boolean.TRUE);
                    bloodStockTracing.setStatus(Status.ARCHIVE.getValue());
                    bloodStockTracing.setStockStatus(StockStatus.NotAvailable.getValue());
                    bloodStockTracing.setUpdatedBy(user);
                    bloodBankService.updateBloodStockTracing(bloodStockTracing);
                } else if (bloodStockTracing.getStockStatus().equals(StockStatus.NotAvailable.getValue())) {
                    bloodStockTracing.setVoided(Boolean.FALSE);
                    bloodStockTracing.setStatus(Status.ACTIVE.getValue());
                    bloodStockTracing.setStockStatus(StockStatus.Available.getValue());
                    bloodStockTracing.setUpdatedBy(user);
                    bloodBankService.updateBloodStockTracing(bloodStockTracing);
                }
                log.info("Blood Stock Tracing Stock Status updated successfully :: " + bloodStockTracing);
                return new ResponseEntity<>(bloodStockTracing, HttpStatus.ACCEPTED);
            }
            log.info("Blood is not available in the stock :: " + bloodStockTracing);
            return new ResponseEntity<>(bloodBagId, HttpStatus.NOT_FOUND);
        }
        log.warn("No valid user found to update the status the blood bag from the stock");
        return new ResponseEntity<>(user, HttpStatus.NOT_ACCEPTABLE);
    }
	
	@RequestMapping(method = RequestMethod.GET, value = "bloodStockTracing/bloodBag/{bloodBagId}")
    @ResponseBody
    public ResponseEntity<Object> getBloodStockByBagId(@PathVariable String bloodBagId) {
        try {
            if (bloodBagId != null) {
                BloodStockTracing bloodStockTracing =
                        bloodBankService.getBloodStockTracingByBloodBagId(bloodBagId);
                log.info("Blood Stock Tracing info is retrieved successfully :: " + bloodStockTracing);
                return new ResponseEntity<>(bloodStockTracing, HttpStatus.OK);
            }
        } catch (Exception e) {
            log.error("Runtime error while trying to find the Blood Stock Tracing", e);
            return new ResponseEntity<>(
                    RestUtil.wrapErrorResponse(e, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
        return null;
    }
	
	@RequestMapping(
            method = RequestMethod.GET,
            value = "bloodCompatibilityTest/bloodBag/{bloodBagId}")
    @ResponseBody
    public ResponseEntity<Object> getCompatibilityByBagId(@PathVariable String bloodBagId) {
        try {
            if (bloodBagId != null) {
                BloodCompatibility bloodCompatibility =
                        bloodBankService.getCompatibilityByBagId(bloodBagId);
                log.info(
                    "Blood Compatibility info is retrieved successfully :: " + bloodCompatibility);
                return new ResponseEntity<>(bloodCompatibility, HttpStatus.OK);
            }
        } catch (Exception e) {
            log.error("Runtime error while trying to find the Blood Compatibility", e);
            return new ResponseEntity<>(
                RestUtil.wrapErrorResponse(e, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
      return null;
  }

    @RequestMapping(method = RequestMethod.POST, value = "bloodSerologyTest/add")
    @ResponseBody
    public ResponseEntity<Object> saveBloodSerology(
        @Valid @RequestBody BloodSerology bloodSerology) {
        if (bloodSerology.getBloodSerologyId() == null) {
            if (bloodSerology.getCreatedBy() != null) {
                bloodBankService.saveBloodSerology(bloodSerology);
                log.info("Blood Serology is saved successfully :: " + bloodSerology);
                return new ResponseEntity<>(bloodSerology, HttpStatus.CREATED);
            }
            log.warn("No valid user found");
            return new ResponseEntity<>("No User found", HttpStatus.BAD_REQUEST);
        }
        if (bloodSerology.getUpdatedBy() != null) {
            bloodBankService.updateBloodSerology(bloodSerology);
            log.info("Blood Serology is updated successfully :: " + bloodSerology);
            return new ResponseEntity<>(bloodSerology, HttpStatus.ACCEPTED);
        }
        log.warn("No valid user found");
        return new ResponseEntity<>("No User found", HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(method = RequestMethod.GET, value = "bloodSerologyTest/list")
    @ResponseBody
    public List<BloodSerology> getAllBloodSerology() {
        List<BloodSerology> bloodSerologies = bloodBankService.getAllBloodSerology();
        log.info("Blood Serology Lists :: " + bloodSerologies);
        return bloodSerologies;
    }

    @RequestMapping(method = RequestMethod.GET, value = "bloodSerologyTest/{id}")
    @ResponseBody
    public ResponseEntity<Object> getBloodSerologyById(@PathVariable Integer id) {
        try {
            if (id != null) {
                BloodSerology bloodSerology = bloodBankService.getBloodSerologyById(id);
                log.info("Blood Serology is retrieved successfully :: " + bloodSerology);
                return new ResponseEntity<>(bloodSerology, HttpStatus.OK);
            }
        } catch (Exception e) {
            log.error("Runtime error while trying to find the Blood Serology", e);
            return new ResponseEntity<>(
                RestUtil.wrapErrorResponse(e, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
        return null;
    }

    @RequestMapping(method = RequestMethod.GET, value = "bloodSerologyTestByPatientId/{id}")
    @ResponseBody
    public ResponseEntity<Object> getBloodSerologyByPatientId(@PathVariable Integer id) {
        try {
            if (id != null) {
                BloodSerology bloodSerology = bloodBankService.getBloodSerologyByPatientId(id);
                log.info("Blood Serology is retrieved successfully :: " + bloodSerology);
                return new ResponseEntity<>(bloodSerology, HttpStatus.OK);
            }
        } catch (Exception e) {
            log.error("Runtime error while trying to find the Blood Serology", e);
            return new ResponseEntity<>(
                RestUtil.wrapErrorResponse(e, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
        return null;
    }

    @RequestMapping(method = RequestMethod.GET, value = "bloodSerologyTestByPatientIdentifier/{identifier}")
    @ResponseBody
    public ResponseEntity<Object> getBloodSerologyByPatientIdentifier(
        @PathVariable String identifier) {
        try {
            if (identifier != null) {
                List<BloodSerology> bloodSerology = bloodBankService.getBloodSerologyByPatientIdentifier(
                    identifier);
                log.info("Blood Serology is retrieved successfully :: " + bloodSerology);
                return new ResponseEntity<>(bloodSerology, HttpStatus.OK);
            }
        } catch (Exception e) {
            log.error("Runtime error while trying to find the Blood Serology", e);
            return new ResponseEntity<>(
                RestUtil.wrapErrorResponse(e, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
        return null;
    }

    @RequestMapping(
        method = RequestMethod.PUT,
        value = "bloodSerologyTest/delete/{id}/by/{user}")
    @ResponseBody
    public ResponseEntity<Object> deleteBloodSerologyById(
        @PathVariable Integer id, @PathVariable String user) {
        BloodSerology bloodSerology = bloodBankService.getBloodSerologyById(id);
        if (user != null && !user.equals("undefined")) {
            bloodSerology.setStatus(Status.DELETE.getValue());
            bloodSerology.setVoided(Boolean.TRUE);
            bloodSerology.setUpdatedBy(user);
            bloodBankService.updateBloodSerology(bloodSerology);
            log.info("Blood Serology is deleted successfully :: " + bloodSerology);
            return new ResponseEntity<>(bloodSerology, HttpStatus.ACCEPTED);
        }
        log.warn("No valid user found");
        return new ResponseEntity<>("No User found", HttpStatus.BAD_REQUEST);
    }
}
