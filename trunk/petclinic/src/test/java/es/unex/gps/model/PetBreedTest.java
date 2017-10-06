package es.unex.gps.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.samples.petclinic.model.PetBreed;

public class PetBreedTest {

	public static PetBreed petBreed;
	
	@BeforeClass
	public static void initClass(){
		petBreed=new PetBreed();
	}
	
	@Before
	//Este metodo se ejecuta antes de ejecutar cada uno de los test de la suite
	public void init(){
		petBreed.setId(1);
	}
	
	@Test
	public void testNameNull() {
		assertNull(petBreed.getName());
	}
	
	@Test
	public void testNameNotNull() {
		petBreed.setName("Burmese");
		assertEquals("Burmese", petBreed.getName());
	}
	
	@AfterClass
	//Este metodo se ejecuta despues de ejecutar los test de la suite
	public static void finishClass(){
		petBreed=null;
	}


}
