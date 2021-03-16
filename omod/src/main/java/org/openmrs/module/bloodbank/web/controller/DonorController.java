package org.openmrs.module.bloodbank.web.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.module.bloodbank.api.model.BloodDonor;
import org.openmrs.module.bloodbank.api.service.BloodDonorService;
import org.openmrs.module.webservices.rest.web.RestConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
		return bloodDonors;
	}
}
