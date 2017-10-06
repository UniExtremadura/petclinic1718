package org.springframework.samples.petclinic.repository;

import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.model.Clinic;

/**
 * 
 * @author Software Project Management
 *
 */

public interface ClinicRepository {
	
	/**
	 * Save a <code>Clinic</code> on the data store, either inserting or updating it.
	 * 
	 * @param The <code>clinic</code> to save
	 */
	void save (Clinic clinic) throws DataAccessException;
	
	/**
	 * Get the <code>Clinic</code> information.
	 * 
	 */
	Clinic get () throws DataAccessException;

}
