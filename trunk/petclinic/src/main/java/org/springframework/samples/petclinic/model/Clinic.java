package org.springframework.samples.petclinic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 
 * @author Software Project Management
 *
 */
@Entity
@Table (name = "clinic")
public class Clinic extends NamedEntity {

	@Column (name = "address")
	private String address;
	
	@Column (name = "vat")
	private String VAT;

	public String getVAT() {
		return VAT;
	}

	public void setVAT(String vAT) {
		VAT = vAT;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
