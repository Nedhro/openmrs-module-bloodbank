package org.openmrs.module.bloodbank.web.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.module.bloodbank.api.model.BloodDonorPhysicalSuitability;
import org.openmrs.module.bloodbank.api.service.BloodBankService;
import org.openmrs.module.webservices.rest.web.RestConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
		List<BloodDonorPhysicalSuitability> BloodDonorPhysicalSuitability = bloodBankService.getAllDonorTestsResult();
		log.info("Blood Donor Physical Suitability Test Lists :: " + BloodDonorPhysicalSuitability);
		return BloodDonorPhysicalSuitability;
	}
}
