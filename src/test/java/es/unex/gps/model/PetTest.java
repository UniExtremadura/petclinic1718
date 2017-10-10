package es.unex.gps.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.joda.time.DateTime;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.samples.petclinic.model.Pet;
import org.springframework.samples.petclinic.model.PetBreed;
import org.springframework.samples.petclinic.model.PetCharacter;
import org.springframework.samples.petclinic.model.PetType;
import org.springframework.samples.petclinic.model.Visit;

public class PetTest {
	
	public static Pet pet;
	
	@BeforeClass
	//Este metodo se ejecuta antes de ejecutar los test de la suite
	public static void initClass(){
		
		
	}
	
	@Before
	//Este metodo se ejecuta antes de ejecutar cada uno de los test de la suite
	public void init(){
		pet=new Pet();
		
		pet.setWeight(12);
		pet.setComments("Comentario de prueba");
		PetCharacter character = new PetCharacter();
		character.setId(1);
		pet.setCharacter(character);		
		pet.setAllergies("eggs");	
	}
	
	@Test
	public void testBirthDateNull(){
		assertNull(pet.getBirthDate());
	}
	
	@Test
	public void testBirthDateNotNull(){
		pet.setBirthDate( new DateTime(2016, 11, 20, 0, 0, 0, 0));
		assertNotNull(pet.getBirthDate());
		assertEquals(new DateTime(2016, 11, 20, 0, 0, 0, 0),pet.getBirthDate());
	}
	
	@Test
	public void testWeight(){
		assertNotNull(pet.getWeight());
		assertEquals(12,pet.getWeight(),0);
	}
	
	@Test
	public void testComments(){
		assertNotNull(pet.getComments());
		assertEquals("Comentario de prueba",pet.getComments());
	}
	
	@Test
	public void testTypeNull(){		
		assertNull(pet.getType());
	}
	@Test
	public void testTypeNotNull(){
		PetType petType = new PetType();
		petType.setId(1);
		petType.setName("cat");
		pet.setType(petType);	
		
		assertNotNull(pet.getType());
		assertEquals(petType,pet.getType());
	}
	
	@Test
	public void testVisitEmpty(){		
		assertEquals(0,pet.getVisits().size());
	}
	@Test
	public void testVisitNotEmpty(){
		Visit visit = new Visit();
		pet.addVisit(visit);

		assertNotNull(pet.getVisits());
		assertEquals(1,pet.getVisits().size());
	}
	
	@Test
	public void testCharacter(){
		assertNotNull(pet.getCharacter());
		assertEquals("Nervous",pet.getCharacter());
	}
	
	@Test
	public void testAllergies(){
		assertNotNull(pet.getAllergies());
		assertEquals("eggs",pet.getAllergies());
	}
	
	
	@Test
	public void testBreedNull(){		
		assertNull(pet.getBreed());	
	}
	
	@Test
	public void testBreedNotNull(){
		PetBreed petBreed = new PetBreed();
		petBreed.setId(2);
		petBreed.setName("American Curl");
		pet.setBreed(petBreed);	
		
		
		assertNotNull(pet.getBreed());
		assertEquals(petBreed,pet.getBreed());
	}
	
	@Ignore
	//Este metodo no se ejecuta cuando se lanzan los test de la suite
	public void ignore(){
		pet.setWeight(0);
	}
	
	@After
	//Este metodo se ejecuta despues de ejecutar cada uno de los test de la suite
	public void finish(){
		pet.setWeight(12);
	}
	
	@AfterClass
	//Este metodo se ejecuta despues de ejecutar los test de la suite
	public static void finishClass(){
		pet=null;
	}

}
