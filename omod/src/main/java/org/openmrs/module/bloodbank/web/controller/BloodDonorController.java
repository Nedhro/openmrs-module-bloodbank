package org.openmrs.module.bloodbank.web.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.module.bloodbank.api.model.BloodDonor;
import org.openmrs.module.bloodbank.api.model.BloodDonorPhysicalSuitability;
import org.openmrs.module.bloodbank.api.model.Questionnaire;
import org.openmrs.module.bloodbank.api.model.dto.PatientDTO;
import org.openmrs.module.bloodbank.api.model.enums.Status;
import org.openmrs.module.bloodbank.api.service.BloodDonorService;
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
public class BloodDonorController {
	
	private Log log = LogFactory.getLog(this.getClass());
	
	@Autowired
	private BloodDonorService bloodDonorService;
	
	@RequestMapping(method = RequestMethod.GET, value = "donor/list")
	@ResponseBody
	public List<BloodDonor> getAllBloodDonor() {
		List<BloodDonor> bloodDonors = bloodDonorService.getAllBloodDonors();
		log.info("Blood Donor Lists :: " + bloodDonors);
		return bloodDonors;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "donor/add")
    @ResponseBody
    public ResponseEntity<Object> saveDonorInfo(@Valid @RequestBody BloodDonor bloodDonor) {
        if (bloodDonor.getDonorId() == null) {
            bloodDonorService.saveDonorInfo(bloodDonor);
            log.info("Blood Donor info is saved successfully :: " + bloodDonor);
            return new ResponseEntity<>(bloodDonor, HttpStatus.CREATED);
        }
        bloodDonorService.updateDonorInfo(bloodDonor);
        log.info("Blood Donor info is updated successfully :: " + bloodDonor);
        return new ResponseEntity<>(bloodDonor, HttpStatus.ACCEPTED);
    }
	
	@RequestMapping(method = RequestMethod.GET, value = "donor/{id}")
    @ResponseBody
    public ResponseEntity<Object> getDonorById(@PathVariable Integer id) {
        try {
            if (id != null) {
                BloodDonor bloodDonor = bloodDonorService.getDonorById(id);
                log.info("Blood Donor is retrieved successfully :: " + bloodDonor);
                return new ResponseEntity<>(bloodDonor, HttpStatus.OK);
            }
        } catch (Exception e) {
            log.error("Runtime error while trying to find the Blood Donor", e);
            return new ResponseEntity<>(RestUtil.wrapErrorResponse(e, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
        return null;
    }
	
	@RequestMapping(method = RequestMethod.PUT, value = "donor/delete/{id}")
    @ResponseBody
    public ResponseEntity<Object> deleteDonerById(@PathVariable Integer id) {
        BloodDonor bloodDonor = bloodDonorService.getDonorById(id);
        bloodDonor.setStatus(Status.DELETE.getValue());
        bloodDonorService.updateDonorInfo(bloodDonor);
        log.info("Blood Donor deleted successfully :: " + bloodDonor);
        return new ResponseEntity<>(bloodDonor, HttpStatus.ACCEPTED);
    }
	
	@RequestMapping(method = RequestMethod.POST, value = "questionnaire/add")
    @ResponseBody
    public ResponseEntity<Object> saveQuestionnaire(@Valid @RequestBody Questionnaire questionnaire) {
        if (questionnaire.getQid() == null) {
            Boolean existQuestion = bloodDonorService.existsByQuestionnaireName(questionnaire.getQuestion());
            if (existQuestion) {
                log.info("Questionnaire exists  :: " + questionnaire);
                return new ResponseEntity<>(questionnaire, HttpStatus.IM_USED);
            }
            bloodDonorService.saveQuestionnaire(questionnaire);
            log.info("Questionnaire is added successfully :: " + questionnaire);
            return new ResponseEntity<>(questionnaire, HttpStatus.CREATED);
        }
        bloodDonorService.updateQuestionnaire(questionnaire);
        log.info("Questionnaire is updated successfully :: " + questionnaire);
        return new ResponseEntity<>(questionnaire, HttpStatus.ACCEPTED);
    }
	
	@RequestMapping(method = RequestMethod.GET, value = "questionnaire/list")
	@ResponseBody
	public List<Questionnaire> getAllQuestionnaires() {
		List<Questionnaire> questionnaireList = bloodDonorService.getAllQuestionnaires();
		log.info("Questionnaire Lists :: " + questionnaireList);
		return questionnaireList;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "questionnaire/{id}")
    @ResponseBody
    public ResponseEntity<Object> getQuestionnaireById(@PathVariable("id") Integer qid) {
        try {
            if (qid != null) {
                Questionnaire questionnaire = bloodDonorService.getQuestionnaireById(qid);
                log.info("Questionnaire is retrieved successfully :: " + questionnaire);
                return new ResponseEntity<>(questionnaire, HttpStatus.OK);
            }
        } catch (Exception e) {
            log.error("Runtime error while trying to find the Questionnaire", e);
            return new ResponseEntity<>(RestUtil.wrapErrorResponse(e, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
        return null;
    }
	
	@RequestMapping(method = RequestMethod.PUT, value = "questionnaire/delete/{id}")
    @ResponseBody
    public ResponseEntity<Object> deleteQuestionnaireById(@PathVariable Integer id) {
        Questionnaire questionnaire = bloodDonorService.getQuestionnaireById(id);
        questionnaire.setStatus(Status.DELETE.getValue());
        bloodDonorService.updateQuestionnaire(questionnaire);
        log.info("Questionnaire deleted successfully :: " + questionnaire);
        return new ResponseEntity<>(questionnaire, HttpStatus.ACCEPTED);
    }
	
	@RequestMapping(method = RequestMethod.POST, value = "bloodDonorPhysicalSuitability/add")
    @ResponseBody
    public ResponseEntity<Object> saveDonorPhysicalSuitability(@Valid @RequestBody BloodDonorPhysicalSuitability donorPhysicalSuitability) {
        if (donorPhysicalSuitability.getDonorPhysicalSuitabilityId() == null) {
            bloodDonorService.saveBloodDonorPhysicalSuitability(donorPhysicalSuitability);
            log.info("Blood Donor Physical Suitability test is saved successfully :: " + donorPhysicalSuitability);
            return new ResponseEntity<>(donorPhysicalSuitability, HttpStatus.CREATED);
        }
        bloodDonorService.updateBloodDonorPhysicalSuitability(donorPhysicalSuitability);
        log.info("Blood Donor Physical Suitability test is updated successfully :: " + donorPhysicalSuitability);
        return new ResponseEntity<>(donorPhysicalSuitability, HttpStatus.ACCEPTED);
    }
	
	@RequestMapping(method = RequestMethod.GET, value = "bloodDonorPhysicalSuitability/list")
	@ResponseBody
	public List<BloodDonorPhysicalSuitability> getAllBloodDonorsPhysicalSuitability() {
		List<BloodDonorPhysicalSuitability> bloodDonorPhysicalSuitabilityList = bloodDonorService
		        .getAllBloodDonorPhysicalSuitability();
		log.info("Blood Donor Physical Suitability Lists :: " + bloodDonorPhysicalSuitabilityList);
		return bloodDonorPhysicalSuitabilityList;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "bloodDonorPhysicalSuitability/{id}")
    @ResponseBody
    public ResponseEntity<Object> getBloodDonorPhysicalSuitabilityById(@PathVariable Integer id) {
        try {
            if (id != null) {
                BloodDonorPhysicalSuitability bloodDonorPhysicalSuitability = bloodDonorService
                        .getBloodDonorPhysicalSuitabilityById(id);
                log.info("Donor physical suitability is retrieved successfully :: "
                        + bloodDonorPhysicalSuitability);
                return new ResponseEntity<>(bloodDonorPhysicalSuitability, HttpStatus.OK);
            }
        } catch (Exception e) {
            log.error("Runtime error while trying to find the donor physical suitability", e);
            return new ResponseEntity<>(RestUtil.wrapErrorResponse(e, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
        return null;
    }
	
	@RequestMapping(method = RequestMethod.PUT, value = "bloodDonorPhysicalSuitability/delete/{id}")
    @ResponseBody
    public ResponseEntity<Object> deleteBloodDonorPhysicalSuitabilityById(@PathVariable Integer id) {
        BloodDonorPhysicalSuitability donorPhysicalSuitability =
                bloodDonorService.getBloodDonorPhysicalSuitabilityById(id);
        donorPhysicalSuitability.setStatus(Status.DELETE.getValue());
        bloodDonorService.updateBloodDonorPhysicalSuitability(donorPhysicalSuitability);
        log.info("Blood Donor Physical Suitability test is deleted successfully :: " + donorPhysicalSuitability);
        return new ResponseEntity<>(donorPhysicalSuitability, HttpStatus.ACCEPTED);
    }
	
	@RequestMapping(value = "patients", method = RequestMethod.GET)
	@ResponseBody
	public List<PatientDTO> getPatientList() {
		List<PatientDTO> patients = this.bloodDonorService.getAllPatients();
		return patients;
	}
}
