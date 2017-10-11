/*
 * Copyright 2002-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.samples.petclinic.web;

import java.util.Collection;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Specialty;
import org.springframework.samples.petclinic.model.Vet;
import org.springframework.samples.petclinic.model.Vets;
import org.springframework.samples.petclinic.service.ClinicService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Juergen Hoeller
 * @author Mark Fisher
 * @author Ken Krebs
 * @author Arjen Poutsma
 */
@Controller
public class VetController {

    private final ClinicService clinicService;

    @ModelAttribute("specialties")
    public Collection<Specialty> populateSpecialties() {
        return this.clinicService.findSpecialties();
    }

    @Autowired
    public VetController(ClinicService clinicService) {
        this.clinicService = clinicService;
    }

    @RequestMapping("/vets")
    public String showVetList(Map<String, Object> model) {
        // Here we are returning an object of type 'Vets' rather than a collection of Vet objects 
        // so it is simpler for Object-Xml mapping
        Vets vets = new Vets();
        vets.getVetList().addAll(this.clinicService.findVets());
        model.put("vets", vets);
        return "vets/vetList";
    }
    
   
    @RequestMapping(value = "/vets/new", method = RequestMethod.GET)
    public String initCreationForm(Map<String, Object> model) {
        Vet vet = new Vet();
        model.put("vet", vet);
        return "vets/createOrUpdateVetForm";
    }
    
    @RequestMapping(value = "/vets/new", method = RequestMethod.POST)
    public String processCreationForm(@ModelAttribute("vet") Vet vet,@RequestParam("specialties") String specialty, BindingResult result, SessionStatus status) {
    	new VetValidator().validate(vet, result);
        if (result.hasErrors()) {
            return "vets/createOrUpdateVetForm";
        } else {
        	vet.addSpecialty(this.clinicService.findSpecialtyByName(specialty));
            this.clinicService.saveVet(vet);
            status.setComplete();
            return "redirect:/vets/" + vet.getId();
        }
    }

    @RequestMapping(value = "/vets/{vetId}/edit", method = RequestMethod.GET)
    public String initUpdateVetForm(@PathVariable("vetId") int vetId, Model model) {
        Vet vet = this.clinicService.findVetById(vetId);
        model.addAttribute(vet);
        return "vets/createOrUpdateVetForm";
    }

    @RequestMapping(value = "/vets/{vetId}/edit", method = RequestMethod.PUT)
    public String processUpdateVetForm(@PathVariable("vetId") int vetId, @Valid Vet vet, BindingResult result, SessionStatus status) {
    	new VetValidator().validate(vet, result);
        if (result.hasErrors()) {
            return "vets/createOrUpdateVetForm";
        } else {
        	Vet vetToSave = this.clinicService.findVetById(vetId);
        	vetToSave.setFirstName(vet.getFirstName());
        	vetToSave.setLastName(vet.getLastName());
        	vetToSave.setHouseCalls(vet.getHouseCalls());
        	vetToSave.setTelephone(vet.getTelephone());
            this.clinicService.saveVet(vetToSave);
            status.setComplete();
            return "redirect:/vets/{vetId}";
        }
    }


    @RequestMapping("/vets/{vetId}")
    public ModelAndView showVet(@PathVariable("vetId") int vetId) {
        ModelAndView mav = new ModelAndView("vets/vetDetails");
        mav.addObject(this.clinicService.findVetById(vetId));
        return mav;
    }
    
    @RequestMapping("/vets/{vetId}/today")
    public ModelAndView showVetToday(@PathVariable("vetId") int vetId) {
        ModelAndView mav = new ModelAndView("vets/vetDetails");
        mav.addObject(this.clinicService.findVetById(vetId));
        mav.addObject("todayVisits",this.clinicService.findTodayVisits(vetId));
        return mav;
    }

}
