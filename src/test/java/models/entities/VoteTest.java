package models.entities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;

import models.utils.Studies;

import org.junit.Before;
import org.junit.Test;

public class VoteTest {
	
	private ArrayList<Vote> data;
	
	@Before
	public void before() {
		this.data = new ArrayList<Vote>();
		this.data.add(new Vote("192.168.1.1", 4.3, Studies.BACHILLERATO, new Theme("Tema 1", "Pregunta 1")));
		this.data.add(new Vote("19.168.1.1", 4.9, Studies.UNIVERSIDAD, new Theme("Tema 1", "Pregunta 2")));
		this.data.add(new Vote("92.8.1.1", 4.0, Studies.ESO, new Theme("Tema 1", "Pregunta 1")));
		this.data.add(new Vote("192.168.1.1", 4.3, Studies.BACHILLERATO, new Theme("Tema 1", "Pregunta 1")));
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
