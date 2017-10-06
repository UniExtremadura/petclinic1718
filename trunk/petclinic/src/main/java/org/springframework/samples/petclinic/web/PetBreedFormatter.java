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


import java.text.ParseException;
import java.util.Collection;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.samples.petclinic.model.PetBreed;
import org.springframework.samples.petclinic.service.ClinicService;

/**
 * 
 */
public class PetBreedFormatter implements Formatter<PetBreed> {

    private final ClinicService clinicService;


    @Autowired
    public PetBreedFormatter(ClinicService clinicService) {
        this.clinicService = clinicService;
    }

    @Override
    public String print(PetBreed petBreed, Locale locale) {
        return petBreed.getName();
    }

    @Override
    public PetBreed parse(String text, Locale locale) throws ParseException {
        Collection<PetBreed> findPetBreeds = this.clinicService.findPetBreeds();
        for (PetBreed breed : findPetBreeds) {
            if (breed.getName().equals(text)) {
                return breed;
            }
        }
        throw new ParseException("breed not found: " + text, 0);
    }

}
