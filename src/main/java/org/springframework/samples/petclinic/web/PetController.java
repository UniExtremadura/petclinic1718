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

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Owner;
import org.springframework.samples.petclinic.model.Pet;
import org.springframework.samples.petclinic.model.PetBreed;
import org.springframework.samples.petclinic.model.PetType;
import org.springframework.samples.petclinic.service.ClinicService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

/**
 * @author Juergen Hoeller
 * @author Ken Krebs
 * @author Arjen Poutsma
 */
@Controller
@SessionAttributes("pet")
public class PetController {

    private final ClinicService clinicService;


    @Autowired
    public PetController(ClinicService clinicService) {
        this.clinicService = clinicService;
    }

    @ModelAttribute("types")
    public Collection<PetType> populatePetTypes() {
        return this.clinicService.findPetTypes();
    }
    
    @ModelAttribute("breeds")
    public Collection<PetBreed> populatePetBreeds() {
        return this.clinicService.findPetBreeds();
    }

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }
    
    @RequestMapping(value = "/pets/find", method = RequestMethod.GET)
    public String initFindForm(Map<String, Object> model) {
    	model.put("pet", new Pet());
        return "pets/findPets";
    }
    
    @RequestMapping(value = "/pets", method = RequestMethod.GET)
    public String processFindForm(Pet pet, BindingResult result, Map<String, Object> model) {
        Collection<Pet> results = this.clinicService.findPetByNameTypeBreed(pet);
        model.put("selections", results);
        return "pets/petsList";
    }

    @RequestMapping(value = "/owners/{ownerId}/pets/new", method = RequestMethod.GET)
    public String initCreationForm(@PathVariable("ownerId") int ownerId, Map<String, Object> model) {
        Owner owner = this.clinicService.findOwnerById(ownerId);
        Pet pet = new Pet();
        owner.addPet(pet);
        model.put("pet", pet);
        model.put("characterTypes", Arrays.asList("Calm","Nervous", "Aggressive"));
        return "pets/createOrUpdatePetForm";
    }

    @RequestMapping(value = "/owners/{ownerId}/pets/new", method = RequestMethod.POST)
    public String processCreationForm(@ModelAttribute("pet") Pet pet, BindingResult result, SessionStatus status) {
        new PetValidator().validate(pet, result);
        if (result.hasErrors()) {
            return "pets/createOrUpdatePetForm";
        } else {
            this.clinicService.savePet(pet);
            status.setComplete();
            return "redirect:/owners/{ownerId}";
        }
    }

    @RequestMapping(value = "/owners/*/pets/{petId}/edit", method = RequestMethod.GET)
    public String initUpdateForm(@PathVariable("petId") int petId, Map<String, Object> model) {
        Pet pet = this.clinicService.findPetById(petId);
        model.put("pet", pet);
        model.put("characterTypes", Arrays.asList("Calm","Nervous", "Aggressive"));
        return "pets/createOrUpdatePetForm";
    }

    @RequestMapping(value = "/owners/{ownerId}/pets/{petId}/edit", method = {RequestMethod.PUT, RequestMethod.POST})
    public String processUpdateForm(@ModelAttribute("pet") Pet pet, BindingResult result, SessionStatus status) {
        // we're not using @Valid annotation here because it is easier to define such validation rule in Java
        new PetValidator().validate(pet, result);
        if (result.hasErrors()) {
            return "pets/createOrUpdatePetForm";
        } else {
            this.clinicService.savePet(pet);
            status.setComplete();
            return "redirect:/owners/{ownerId}";
        }
    }
    
    @RequestMapping(value = "/owners/{ownerId}/pets/{petId}/delete", method = RequestMethod.GET)
    public String deletePet(@PathVariable("petId") int petId, Map<String, Object> model) {
    	this.clinicService.deletePetById(petId);
    	return "redirect:/owners/{ownerId}";
    }
    
}
