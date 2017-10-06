package org.springframework.samples.petclinic.repository.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.model.Clinic;
import org.springframework.samples.petclinic.repository.ClinicRepository;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author Software Project Management
 *
 */
@Repository
public class JpaClinicRepository implements ClinicRepository {
	
	@PersistenceContext
    private EntityManager em;

	@Override
	public void save(Clinic clinic) throws DataAccessException {
		if (clinic.getId() == null) {
    		this.em.persist(clinic);     		
    	}
    	else {
    		this.em.merge(clinic);    
    	}

	}

	@Override
	public Clinic get() throws DataAccessException {
		Query query = this.em.createQuery("SELECT clinic FROM Clinic clinic");
        Clinic clinic =  (Clinic) query.getSingleResult();
        return clinic;
		
	}

}
