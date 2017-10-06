package org.springframework.samples.petclinic.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Clinic;
import org.springframework.samples.petclinic.service.ClinicService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

/**
 * 
 * @author Software Project Management
 *
 */
@Controller
@SessionAttributes("clinic")
public class ClinicController {

	private final ClinicService clinicService;

	@Autowired
	public ClinicController(ClinicService clinicService) {
		this.clinicService = clinicService;
	}

	@RequestMapping(value = "/clinic", method = RequestMethod.GET)
	public String initSaveForm(Map<String, Object> model) {
		Clinic clinic = this.clinicService.getClinicInfo();
		model.put("clinic", clinic);
		return "clinic/createOrUpdateClinicForm";
	}

	@RequestMapping(value = "/clinic", method = RequestMethod.PUT)
	public String processSaveForm(@ModelAttribute("clinic") Clinic clinic, BindingResult result, SessionStatus status) {
		this.clinicService.saveClinic(clinic);
		status.setComplete();
		return "redirect:/clinic";
	}

}
