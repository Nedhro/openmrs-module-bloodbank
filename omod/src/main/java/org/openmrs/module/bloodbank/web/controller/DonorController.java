package org.openmrs.module.bloodbank.web.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.module.bloodbank.api.model.BloodDonor;
import org.openmrs.module.bloodbank.api.model.BloodDonorPhysicalSuitability;
import org.openmrs.module.bloodbank.api.model.Questionnaire;
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

    @RequestMapping(method = RequestMethod.GET, value = "donors")
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
            log.info("Blood Donor info is saved successfully :: " + bloodDonor);
            return new ResponseEntity<>(bloodDonor, HttpStatus.CREATED);
        } catch (Exception e) {
            log.error("Runtime error while trying to save blood donor info", e);
            return new ResponseEntity<>(RestUtil.wrapErrorResponse(e, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "questionnaire/add")
    @ResponseBody
    public ResponseEntity<Object> saveDonorInfo(@Valid @RequestBody Questionnaire questionnaire) {
        try {
            Boolean existQuestion = bloodDonorService.existsByQuestionnaireName(questionnaire.getQuestion());
            if (existQuestion) {
                log.info("Questionnaire exists  :: " + questionnaire);
                return new ResponseEntity<>(questionnaire, HttpStatus.IM_USED);
            }
            bloodDonorService.saveQuestionnaire(questionnaire);
            log.info("Questionnaire is added successfully :: " + questionnaire);
            return new ResponseEntity<>(questionnaire, HttpStatus.CREATED);
        } catch (Exception e) {
            log.error("Runtime error while trying to save questionnaire", e);
            return new ResponseEntity<>(RestUtil.wrapErrorResponse(e, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "questionnaire/list")
    @ResponseBody
    public List<Questionnaire> getAllQuestionnaires() {
        List<Questionnaire> questionnaireList = bloodDonorService.getAllQuestionnaires();
        log.info("Questionnaire Lists :: " + questionnaireList);
        return questionnaireList;
    }

    @RequestMapping(method = RequestMethod.POST, value = "bloodDonorPhysicalSuitability/add")
    @ResponseBody
    public ResponseEntity<Object> saveDonorPhysicalSuitability(@Valid @RequestBody BloodDonorPhysicalSuitability donorPhysicalSuitability) {
        try {
            bloodDonorService.saveBloodDonorPhysicalSuitability(donorPhysicalSuitability);
            return new ResponseEntity<>(donorPhysicalSuitability, HttpStatus.CREATED);
        } catch (Exception e) {
            log.error("Runtime error while trying to save donor physical suitability", e);
            return new ResponseEntity<>(RestUtil.wrapErrorResponse(e, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "bloodDonorPhysicalSuitability/list")
    @ResponseBody
    public List<BloodDonorPhysicalSuitability> getAllBloodDonorsPhysicalSuitability() {
        List<BloodDonorPhysicalSuitability> bloodDonorPhysicalSuitabilityList = bloodDonorService
                .getAllBloodDonorPhysicalSuitability();
        log.info("Blood Donor Physical Suitability Lists :: " + bloodDonorPhysicalSuitabilityList);
        return bloodDonorPhysicalSuitabilityList;
    }
}
