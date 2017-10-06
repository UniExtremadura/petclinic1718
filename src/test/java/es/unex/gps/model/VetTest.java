package es.unex.gps.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.samples.petclinic.model.Vet;

public class VetTest {
	
public static Vet vet;
	
	@BeforeClass
	//Este metodo se ejecuta antes de ejecutar los test de la suite
	public static void initClass(){
		vet=new Vet();
		vet.setFirstName("Juanma");
		vet.setLastName("Murillo");
		vet.setHouseCalls(true);
	}
	
	@Before
	//Este metodo se ejecuta antes de ejecutar cada uno de los test de la suite
	public void init(){
		vet.setHouseCalls(false);
	}
	
	@Test
	public void testFirstNameNotNull(){
		assertNotNull(vet.getFirstName());
		assertEquals("Juanma", vet.getFirstName());
	}
	
	@Test
	public void testLastNameNotNull(){
		assertNotNull(vet.getLastName());
		assertEquals("Murillo", vet.getLastName());
	}
	
	@Test
	public void testHouseCall(){
		assertNotNull(vet.getHouseCalls());
		assertFalse(vet.getHouseCalls());
	}
	
	@Ignore
	//Este metodo no se ejecuta cuando se lanzan los test de la suite
	public void ignore(){
		vet.setFirstName("Juan Manuel");
	}
	
	@After
	//Este metodo se ejecuta despues de ejecutar cada uno de los test de la suite
	public void finish(){
		vet.setHouseCalls(true);
	}
	
	@AfterClass
	//Este metodo se ejecuta despues de ejecutar los test de la suite
	public static void finishClass(){
		vet=null;
	}

}
