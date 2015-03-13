package models.entities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class ThemeTest {

private ArrayList<Theme> data;
	
	@Before
	public void before() {
		this.data = new ArrayList<Theme>();
		this.data.add(new Theme("Tema 1", "Pregunta 1"));
		this.data.add(new Theme("Tema 1", "Pregunta 2"));
		this.data.add(new Theme("Tema 2", "Pregunta 1"));
		this.data.add(new Theme("Tema 1", "Pregunta 1"));		
	}

	@Test
	public void testEqualsObject() {
		assertEquals(data.get(0), data.get(0));
		assertEquals(data.get(0), data.get(3));
		assertNotEquals(data.get(0), data.get(1));
		assertNotEquals(data.get(1), data.get(2));
		assertNotEquals(data.get(2), data.get(0));
	}

}
