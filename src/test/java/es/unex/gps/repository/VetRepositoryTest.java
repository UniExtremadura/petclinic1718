package es.unex.gps.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Vet;
import org.springframework.samples.petclinic.repository.VetRepository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@ContextConfiguration(locations = {"classpath:spring/business-config.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class VetRepositoryTest {
	
	@Autowired
	private VetRepository vetRepository;
	
	private Vet vet;
	
	@Before	
	public void init(){
		Collection<Vet> c=this.vetRepository.findAll();
		for(Vet v : c){
			if(v.getLastName().equals("Murillo")){
				this.vet=v;
			}
		}
		if(this.vet==null){
			this.vet=new Vet();
			this.vet.setFirstName("Juanma");
			this.vet.setLastName("Murillo");
			this.vet.setHouseCalls(true);
			this.vetRepository.save(this.vet);
			this.vet=this.vetRepository.findById(this.vet.getId());
		}
	}
	
	@Test
	@Transactional
	public void testSave() {		
		assertNotNull(this.vet.getId());
		assertEquals("Juanma", this.vet.getFirstName());
		assertEquals("Murillo", this.vet.getLastName());
		assertTrue(this.vet.getHouseCalls());
	}
	
	@Test
	@Transactional
	public void testUpdate() {		
		this.vet.setHouseCalls(false);
		this.vetRepository.save(this.vet);
		this.vet = this.vetRepository.findById(this.vet.getId());
		assertFalse(this.vet.getHouseCalls());
	}		
	
	@After
	public void finish(){
		this.vet=null;
	}
	
}

