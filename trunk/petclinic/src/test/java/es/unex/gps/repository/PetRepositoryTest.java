package es.unex.gps.repository;

import static org.junit.Assert.*;

import java.util.Collection;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Pet;
import org.springframework.samples.petclinic.model.PetBreed;
import org.springframework.samples.petclinic.model.PetType;
import org.springframework.samples.petclinic.repository.PetRepository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@ContextConfiguration(locations = {"classpath:spring/business-config.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class PetRepositoryTest {

	@Autowired
	private PetRepository petRepository;
	
	@BeforeClass
	public static void initClass(){
		
	}
	
	@Before
	public void init(){
		
	}
	
	@Test
	@Transactional
	public void testFindPetTypes() {
		List <PetType> listPetTypes = petRepository.findPetTypes(); 
		assertNotNull(listPetTypes);
		assertEquals(listPetTypes.size(), 6, 0);
	}
	
	@Test
	@Transactional
	public void testFindPetBreeds() {
		List <PetBreed> listPetBreeds = petRepository.findPetBreeds(); 
		assertNotNull(listPetBreeds);
		assertEquals(listPetBreeds.size(), 7, 0);
	}
	
	@Test
	@Transactional
	public void testFindById() {
		Pet pet = petRepository.findById(1); 
		assertNotNull(pet);
		assertEquals(pet.getId(), 1, 0);
	}
	
	@Test
	@Transactional
	public void testfindPetByNameTypeBreedNameEmpty() {
		Pet pet = new Pet();
		pet.setName("");
		Collection<Pet> pets = petRepository.findPetByNameTypeBreed(pet); 
		assertNotNull(pets);
		assertEquals(pets.size(), 13, 0);
	}
	
	@Test
	@Transactional
	public void testfindPetByNameTypeBreedWithName() {
		Pet pet = new Pet();
		pet.setName("Leo");
		Collection<Pet> pets = petRepository.findPetByNameTypeBreed(pet); 
		assertNotNull(pets);
		assertEquals(pets.size(), 1, 0);
	}

	@Test
	@Transactional
	public void testfindPetByNameTypeBreedWithType() {
		Pet pet = new Pet();
		pet.setName("");
		pet.setType(petRepository.findPetTypes().get(1));
		Collection<Pet> pets = petRepository.findPetByNameTypeBreed(pet); 
		assertNotNull(pets);
		assertEquals(pets.size(), 4, 0);
	}
	
	@Test
	@Transactional
	public void testfindPetByNameTypeBreedWithBreed() {
		Pet pet = new Pet();
		pet.setName("");
		pet.setBreed(petRepository.findPetBreeds().get(2));
		Collection<Pet> pets = petRepository.findPetByNameTypeBreed(pet); 
		assertNotNull(pets);
		assertEquals(pets.size(), 1, 0);
	}
	
	@After
	public void finish(){
		
	}
	
	@AfterClass
	public static void finishClass(){
		
	}

}
