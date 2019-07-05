package ar.edu.unq.epers.unidad5;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ar.edu.unq.epers.unidad5.dao.PersonaNeo4jDAO;
import ar.edu.unq.epers.unidad5.model.Persona;

public class PersonaNeo4jDAOTest {

	private PersonaNeo4jDAO dao;
	
	@Before
	public void setUp() {
		this.dao = new PersonaNeo4jDAO();
	}
	
	@Test
	public void crearPersona() {
		Persona persona = new Persona("300000", "Jerry", "Smith");
		this.dao.create(persona);
		
		Persona persona2 = new Persona("300001", "Morty", "Smith");
		this.dao.create(persona2);
		
		this.dao.crearRelacionEsHijoDe(persona, persona2);
	}
	
	@Test
	public void hijosDe() {
		Persona persona = new Persona("300000", "Jerry", "Smith");
		this.dao.create(persona);

		Persona persona2 = new Persona("300001", "Morty", "Smith");
		this.dao.create(persona2);
		
		Persona persona3 = new Persona("300002", "Summer", "Smith");
		this.dao.create(persona3);
		
		this.dao.crearRelacionEsHijoDe(persona, persona2);
		this.dao.crearRelacionEsHijoDe(persona, persona3);
		
		List<Persona> hijos = this.dao.getHijosDe(persona);
		Assert.assertEquals(2, hijos.size());
		
		Assert.assertTrue(hijos.contains(persona2));
		Assert.assertTrue(hijos.contains(persona3));
	}
	
	
	
}
