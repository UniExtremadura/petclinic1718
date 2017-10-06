package es.unex.gps.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Collection;

import org.joda.time.DateTime;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Visit;
import org.springframework.samples.petclinic.repository.PetRepository;
import org.springframework.samples.petclinic.repository.VetRepository;
import org.springframework.samples.petclinic.repository.VisitRepository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@ContextConfiguration(locations = {"classpath:spring/business-config.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class VisitRepositoryTest {
	
	@Autowired
	private VisitRepository visitRepository;
	
	@Autowired
	private VetRepository vetRepository;
	
	@Autowired
	private PetRepository petRepository;
	
	private static Visit visit;
	
	@BeforeClass
	//Este metodo se ejecuta antes de ejecutar los test de la suite
	public static void initClass(){
		visit = new Visit();
		visit.setDate(new DateTime(2016, 12, 20, 0, 0, 0, 0));
		visit.setDescription("Short Description");
		visit.setDiagnosis("Diagnosis");
		visit.setTreatment("Treatment");		
	}
	
	@Before
	public void init(){		
		visit.setPet(petRepository.findById(1));
		visit.setVet(vetRepository.findById(1));
	}
	
	@Test
	@Transactional
	public void testSave() {
		this.visitRepository.save(visit);
		System.out.println(visit);
	}
	
	@Test
	@Transactional
	public void testFindByPetId() {
		Collection<Visit> visits = this.visitRepository.findByPetId(petRepository.findById(1).getId());
		assertEquals (visits.size(), 1);
	}	
	
	@Test
	@Transactional
	public void testFindById() {
		Visit newVisit = this.visitRepository.findById(1);
		assertEquals (newVisit.getId(),1,0);
	}
	
	@Test
	@Transactional
	public void testFindByIdEMpty() {
		Visit newVisit = this.visitRepository.findById(1000);
		assertNull (newVisit);
	}
		
		
	@Test
	@Transactional
	public void testFindVisitsByDate() {
		Collection<Visit> visits = this.visitRepository.findVisitsByDate(petRepository.findById(1).getId(), new DateTime().minusMonths(1) , new DateTime().plusMonths(1));
		assertEquals (visits.size(),0);
	}	
			
	@AfterClass
	public static void finishClass(){
		visit=null;
	}
	
}

