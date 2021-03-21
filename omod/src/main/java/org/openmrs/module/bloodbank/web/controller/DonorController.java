package org.openmrs.module.bloodbank.web.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.module.bloodbank.api.model.BloodDonor;
import org.openmrs.module.bloodbank.api.service.BloodDonorService;
import org.openmrs.module.webservices.rest.web.RestConstants;
import org.openmrs.module.webservices.rest.web.RestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = "/rest/" + RestConstants.VERSION_1 + "/bloodbank")
public class DonorController {
	
	private Log log = LogFactory.getLog(this.getClass());
	
	@Autowired
	private BloodDonorService bloodDonorService;
	
	@RequestMapping(method = RequestMethod.GET, value = "all")
	@ResponseBody
	public List<BloodDonor> getAllBloodDonor() {
		List<BloodDonor> bloodDonors = bloodDonorService.getAllBloodDonors();
		log.info("Blood Donor Lists :: " + bloodDonors);
		return bloodDonors;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "donorForm")
    @ResponseBody
    public ResponseEntity<Object> saveDonorInfo(@Valid @RequestBody BloodDonor bloodDonor) {
        try {
			bloodDonorService.saveDonorInfo(bloodDonor);
			return new ResponseEntity<>(bloodDonor, HttpStatus.OK);
		} catch (Exception e) {
			log.error("Runtime error while trying to save blood donor info", e);
			return new ResponseEntity<>(RestUtil.wrapErrorResponse(e, e.getMessage()), HttpStatus.BAD_REQUEST);
		}
    }
}
