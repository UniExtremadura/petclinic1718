package es.unex.gps.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

import org.joda.time.DateTime;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.samples.petclinic.model.Pet;
import org.springframework.samples.petclinic.model.Vet;
import org.springframework.samples.petclinic.model.Visit;

public class VisitTest {
	
	public static Visit visit;
		
	@BeforeClass
	//Este metodo se ejecuta antes de ejecutar los test de la suite
	public static void initClass(){					
	}
	
	@Before
	//Este metodo se ejecuta antes de ejecutar cada uno de los test de la suite
	public void init(){
		visit = new Visit ();	
		visit.setDate( new DateTime(2016, 11, 20, 0, 0, 0, 0));
	}
	
	@Test
	public void testDate(){
		assertNotNull(visit.getDate());		
		assertEquals(new DateTime(2016, 11, 20, 0, 0, 0, 0), visit.getDate());
	}
	
	@Test
	public void testDescriptionNull(){
		assertNull(visit.getDescription());
	}
	@Test
	public void testDescriptionNotNull(){
		visit.setDescription("description");
		
		assertNotNull(visit.getDescription());		
		assertSame("description", visit.getDescription());
	}
	
	@Test
	public void testPetNull(){
		assertNull(visit.getPet());
	}
	
	@Test
	public void testPetNotNull(){
		Pet pet=new Pet();
		pet.setId(1);
		pet.setWeight(12);
		pet.setComments("Comentario de prueba");
		
		visit.setPet(pet);
		assertNotNull(visit.getPet());
		assertEquals(1,visit.getPet().getId(),0);
	}
	
	@Test
	public void testVetNull(){
		assertNull(visit.getVet());
	}
	
	@Test
	public void testVetNotNull(){	
		Vet vet=new Vet();
		vet.setId(1);
		
		visit.setVet(vet);
		assertNotNull(visit.getVet());
		assertEquals(1,visit.getVet().getId(),0);
	}
	
	
	@Test
	public void testDiagnosisNull(){
		assertNull(visit.getDiagnosis());
	}
	
	@Test
	public void testDiagnosisNotNull(){
		visit.setDiagnosis("diagnosis");
		
		assertNotNull(visit.getDiagnosis());		
		assertSame("diagnosis", visit.getDiagnosis());
	}
	
	@Test
	public void testTreatmentNull(){
		assertNull(visit.getTreatment());
	}
	
	@Test
	public void testTreatmentNotNull(){
		visit.setTreatment("treatment");
		
		assertNotNull(visit.getTreatment());		
		assertSame("treatment", visit.getTreatment());
	}
	

	@AfterClass
	//Este metodo se ejecuta despues de ejecutar los test de la suite
	public static void finishClass(){
		visit=null;
	}

}
