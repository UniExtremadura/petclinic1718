package es.unex.gps.repository;

import static org.junit.Assert.*;

import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Owner;
import org.springframework.samples.petclinic.repository.OwnerRepository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@ContextConfiguration(locations = {"classpath:spring/business-config.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class OwnerRepositoryTest {
	
	@Autowired
	private OwnerRepository ownerRepository;
	
	private Owner owner;
	
	@Before	
	public void init(){
		Collection<Owner> c=this.ownerRepository.findByLastName("Murillo");
		if(c.isEmpty()){
			this.owner=new Owner();
			this.owner.setFirstName("Juan Manuel");
			this.owner.setLastName("Murillo");
			this.owner.setCity("Caceres");
			this.owner.setAddress("Avd. de la Universidad s/n");
			this.owner.setTelephone("57266");
			this.ownerRepository.save(owner);
			this.owner=this.ownerRepository.findByLastName("Murillo").iterator().next();
			
		}
		else{
			this.owner=c.iterator().next();
		}
		
	}
	
	@Test
	@Transactional
	public void testSave() {		
		assertNotNull(this.owner.getId());
		assertEquals("Juan Manuel", this.owner.getFirstName());
		assertEquals("Murillo", this.owner.getLastName());
		assertEquals("Caceres", this.owner.getCity());
		assertEquals("Avd. de la Universidad s/n", this.owner.getAddress());
		assertEquals("57266", this.owner.getTelephone());
	}
	
	@Test
	@Transactional
	public void testFindByLastName() {
		Owner existingOwner=this.ownerRepository.findByLastName("Estaban").iterator().next();
		assertNotNull(existingOwner.getId());
		assertEquals("Carlos", existingOwner.getFirstName());
		assertEquals("Estaban", existingOwner.getLastName());
	}
	
	@Test
	@Transactional
	public void testFindById() {
		Owner existingOwner=this.ownerRepository.findById(10);
		assertEquals(10, existingOwner.getId().longValue());
		assertEquals("Carlos", existingOwner.getFirstName());
		assertEquals("Estaban", existingOwner.getLastName());
	}
		
	
	@After
	public void finish(){
		this.owner=null;
	}
	
}
