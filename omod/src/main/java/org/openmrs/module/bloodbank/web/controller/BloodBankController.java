package org.openmrs.module.bloodbank.web.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.module.bloodbank.api.model.BloodCompatibility;
import org.openmrs.module.bloodbank.api.model.BloodDonorPhysicalSuitability;
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
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
    public ResponseEntity<Object> saveBloodCompatibility(@Valid @RequestBody BloodCompatibility bloodCompatibility) {
        if (bloodCompatibility.getBloodCompatibilityId() == null) {
            bloodBankService.saveBloodCompatibility(bloodCompatibility);
            log.info("Blood Compatibility is saved successfully :: " + bloodCompatibility);
            return new ResponseEntity<>(bloodCompatibility, HttpStatus.CREATED);
        }
        bloodBankService.updateBloodCompatibility(bloodCompatibility);
        log.info("Blood Compatibility is updated successfully :: " + bloodCompatibility);
        return new ResponseEntity<>(bloodCompatibility, HttpStatus.ACCEPTED);
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
            return new ResponseEntity<>(RestUtil.wrapErrorResponse(e, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
        return null;
    }
	
	@RequestMapping(method = RequestMethod.PUT, value = "bloodCompatibilityTest/delete/{id}")
    @ResponseBody
    public ResponseEntity<Object> deleteBloodCompatibilityById(@PathVariable Integer id) {
        BloodCompatibility bloodCompatibility = bloodBankService.getBloodCompatibilityById(id);
        bloodCompatibility.setStatus(Status.DELETE.getValue());
        bloodBankService.updateBloodCompatibility(bloodCompatibility);
        log.info("Blood Compatibility is deleted successfully :: " + bloodCompatibility);
        return new ResponseEntity<>(bloodCompatibility, HttpStatus.ACCEPTED);
    }
	
	@RequestMapping(method = RequestMethod.POST, value = "bloodStockTracing/add")
    @ResponseBody
    public ResponseEntity<Object> saveBloodStockTracing(@Valid @RequestBody BloodStockTracing bloodStockTracing) {
        if (bloodStockTracing.getBloodStockTracingId() == null) {
            BloodStockTracing stockTracing = bloodBankService.saveBloodStockTracing(bloodStockTracing);
            if (stockTracing == null) {
                return new ResponseEntity<>(bloodStockTracing, HttpStatus.IM_USED);
            }
            log.info("Blood Stock Tracing info is saved successfully :: " + bloodStockTracing);
            return new ResponseEntity<>(bloodStockTracing, HttpStatus.CREATED);
        }
        bloodBankService.updateBloodStockTracing(bloodStockTracing);
        log.info("Blood Stock Tracing info is updated successfully :: " + bloodStockTracing);
        return new ResponseEntity<>(bloodStockTracing, HttpStatus.ACCEPTED);
    }
	
	@RequestMapping(method = RequestMethod.GET, value = "bloodStockTracing/list")
	@ResponseBody
	public List<BloodStockTracing> getAllBloodStockTracing() {
		List<BloodStockTracing> bloodStockTracings = bloodBankService.getAllBloodStockTracing();
		log.info("Blood Stock Tracing Lists :: " + bloodStockTracings);
		return bloodStockTracings;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "bloodStockTracing/{id}")
    @ResponseBody
    public ResponseEntity<Object> getBloodStockTracingById(@PathVariable Integer id) {
        try {
            if (id != null) {
                BloodStockTracing bloodStockTracing = bloodBankService.getBloodStockTracingById(id);
                log.info("Blood Stock Tracing info is retrieved successfully :: " + bloodStockTracing);
                return new ResponseEntity<>(bloodStockTracing, HttpStatus.OK);
            }
        } catch (Exception e) {
            log.error("Runtime error while trying to find the Blood Stock Tracing", e);
            return new ResponseEntity<>(RestUtil.wrapErrorResponse(e, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
        return null;
    }
	
	@RequestMapping(method = RequestMethod.PUT, value = "bloodStockTracing/delete/{id}")
    @ResponseBody
    public ResponseEntity<Object> deleteBloodStockTracingById(@PathVariable Integer id) {
        BloodStockTracing bloodStockTracing = bloodBankService.getBloodStockTracingById(id);
        bloodStockTracing.setStatus(Status.DELETE.getValue());
        bloodBankService.updateBloodStockTracing(bloodStockTracing);
        log.info("Blood Stock Tracing is deleted successfully :: " + bloodStockTracing);
        return new ResponseEntity<>(bloodStockTracing, HttpStatus.ACCEPTED);
    }
	
	@RequestMapping(method = RequestMethod.PUT, value = "bloodStockTracing/updateStatus/{bloodBagId}")
    @ResponseBody
    public ResponseEntity<Object> updateBloodStockTracingStatus(@PathVariable String bloodBagId) {
        BloodStockTracing bloodStockTracing = bloodBankService.getBloodStockTracingByBloodBagId(bloodBagId);
        if (bloodStockTracing != null) {
            if(bloodStockTracing.getStockStatus() == StockStatus.Available){
                bloodStockTracing.setStockStatus(StockStatus.NotAvailable);
                bloodBankService.updateBloodStockTracing(bloodStockTracing);
            }
            else if(bloodStockTracing.getStockStatus() == StockStatus.NotAvailable){
                bloodStockTracing.setStockStatus(StockStatus.Available);
                bloodBankService.updateBloodStockTracing(bloodStockTracing);
            }
            log.info("Blood Stock Tracing Stock Status updated successfully :: " + bloodStockTracing);
            return new ResponseEntity<>(bloodStockTracing, HttpStatus.ACCEPTED);
        }
        log.info("Blood is not available in the stock :: " + bloodStockTracing);
        return new ResponseEntity<>(bloodBagId, HttpStatus.IM_USED);
    }
	
	@RequestMapping(method = RequestMethod.GET, value = "bloodStockTracing/bloodBag/{bloodBagId}")
    @ResponseBody
    public ResponseEntity<Object> getBloodStockByBagId(@PathVariable String bloodBagId){
        try {
            if (bloodBagId != null) {
                BloodStockTracing bloodStockTracing = bloodBankService.getBloodStockTracingByBloodBagId(bloodBagId);
                log.info("Blood Stock Tracing info is retrieved successfully :: " + bloodStockTracing);
                return new ResponseEntity<>(bloodStockTracing, HttpStatus.OK);
            }
        } catch (Exception e) {
            log.error("Runtime error while trying to find the Blood Stock Tracing", e);
            return new ResponseEntity<>(RestUtil.wrapErrorResponse(e, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
        return null;
    }
	
	@RequestMapping(method = RequestMethod.GET, value = "bloodCompatibilityTest/bloodBag/{bloodBagId}")
    @ResponseBody
    public ResponseEntity<Object> getCompatibilityByBagId(@PathVariable String bloodBagId){
        try {
            if (bloodBagId != null) {
                BloodCompatibility bloodCompatibility = bloodBankService.getCompatibilityByBagId(bloodBagId);
                log.info("Blood Compatibility info is retrieved successfully :: " + bloodCompatibility);
                return new ResponseEntity<>(bloodCompatibility, HttpStatus.OK);
            }
        } catch (Exception e) {
            log.error("Runtime error while trying to find the Blood Compatibility", e);
            return new ResponseEntity<>(RestUtil.wrapErrorResponse(e, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
        return null;
    }
}
