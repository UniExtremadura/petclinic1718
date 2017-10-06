package es.unex.gps;

import static org.junit.Assert.*;

import java.util.Collection;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Vet;
import org.springframework.samples.petclinic.service.ClinicService;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@ContextConfiguration(locations = {"classpath:spring/business-config.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class ClinicServiceTest {
    
	@Autowired
    protected ClinicService clinicService;
	
	@Test
	@Transactional
	public void saveVetTest(){
		Vet vet=new Vet();
		vet.setFirstName("Sr");
		vet.setLastName("Negro");
		assertNull(vet.getId());
		clinicService.saveVet(vet);
		assertNotNull(vet.getId());
	}
	
	@Test
	public void findVetByIdTest(){
		Collection<Vet> c=clinicService.findVets();
		for(Vet vet:c){
			Vet vet2=clinicService.findVetById(vet.getId());
			assertEquals(vet.getId(),vet2.getId());
			assertEquals(vet.getFirstName(),vet2.getFirstName());
			assertEquals(vet.getLastName(),vet2.getLastName());
		}
	}
	
	@AfterClass
	public static void finish(){
		//Se deberia borrar lo insertado en la base de datos
		//El estado del sistema debe ser el mismo antes y despues de ejecutar los test
	}
	
}
