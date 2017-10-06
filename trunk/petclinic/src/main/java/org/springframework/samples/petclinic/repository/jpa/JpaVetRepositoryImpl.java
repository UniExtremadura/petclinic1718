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
package org.springframework.samples.petclinic.repository.jpa;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.joda.time.DateTime;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.model.Specialty;
import org.springframework.samples.petclinic.model.Vet;
import org.springframework.samples.petclinic.model.Visit;
import org.springframework.samples.petclinic.repository.VetRepository;
import org.springframework.stereotype.Repository;

/**
 * JPA implementation of the {@link VetRepository} interface.
 *
 * @author Mike Keith
 * @author Rod Johnson
 * @author Sam Brannen
 * @author Michael Isvy
 * @since 22.4.2006
 */
@Repository
public class JpaVetRepositoryImpl implements VetRepository {

    @PersistenceContext
    private EntityManager em;


    @Override
    //@Cacheable(value = "vets")
    @SuppressWarnings("unchecked")
    public Collection<Vet> findAll() {
        return this.em.createQuery("SELECT distinct vet FROM Vet vet left join fetch vet.specialties ORDER BY vet.lastName, vet.firstName").getResultList();
    }

	@Override
	public Vet findById(int id) {
		Query query = this.em.createQuery("SELECT distinct vet FROM Vet vet left join fetch vet.specialties WHERE id = :id");
        query.setParameter("id", id);
        Vet vet = (Vet) query.getSingleResult();
        return vet;
	}

	@Override
	public void save(Vet vet) {
    	if (vet.getId() == null) {
    		this.em.persist(vet);     		
    	}
    	else {
    		this.em.merge(vet);    
    	}

	}

	@Override
	@SuppressWarnings("unchecked")
	public Collection<Specialty> findSpecialties() throws DataAccessException {
		 return this.em.createQuery("SELECT specialty FROM Specialty specialty ORDER BY specialty.name").getResultList();
	}

	@Override
	public Specialty findSpecialtyByName(String specialty)
			throws DataAccessException {
		Query query = this.em.createQuery("SELECT specialty FROM Specialty specialty WHERE name = :specialty");
        query.setParameter("specialty", specialty);
        Specialty spec = (Specialty) query.getSingleResult();
        return spec;
	}

	@Override
	public Object findTodayVisits(int vetId) throws DataAccessException {
		List<Visit> todayVisits=new ArrayList<Visit>();
		Query query = this.em.createQuery("SELECT distinct vet FROM Vet vet left join fetch vet.specialties WHERE id = :id");
        query.setParameter("id", vetId);
        Vet vet = (Vet) query.getSingleResult();
        DateTime today=new DateTime();
        for(Visit visit: vet.getVisits()){
        	if(visit.getDate().toLocalDate().compareTo(today.toLocalDate())==0){
        		todayVisits.add(visit);
        	}       	
        }
        return todayVisits;
	}

}
