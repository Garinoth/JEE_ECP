package models.daos.jpa;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import models.daos.GenericDao;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public abstract class DaoJpaTest<E> {
	
	protected ArrayList<E> data;
	protected GenericDao<E, Integer> dao;
	
	@BeforeClass
	public static void beforeClass() {
		DaoJpaFactory.setFactory(new DaoJpaFactory());
		DaoJpaFactory.prepareFactoryWithDropAndCreateTables();
	}
	
	@Before
	public void before() {
		this.data = new ArrayList<E>();
	}
		
	@Test
	public void testCreate() {
		for (E e: data) {
			dao.create(e);			
		}
        List<E> entities = dao.findAll();
        for (E e: data) {
            assertTrue(entities.contains(e));
        }
        assertTrue(entities.size() == data.size());
	}

	@Test
	public void testRead() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteById() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindAll() {
		fail("Not yet implemented");
	}
	
}
