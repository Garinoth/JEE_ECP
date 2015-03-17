package models.daos.jpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import models.daos.GenericDao;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public abstract class DaoJpaTest<E> {
	
	protected ArrayList<E> data;
	protected GenericDao<E, Integer> dao;
	
	protected abstract ArrayList<E> supplyData();
	protected abstract GenericDao<E, Integer> supplyDao();
	
	@BeforeClass
	public static void beforeClass() {
		DaoJpaFactory.setFactory(new DaoJpaFactory());
		DaoJpaFactory.prepareFactoryWithDropAndCreateTables();
	}
	
	@Before
	public void before() {
		this.data = supplyData();
		this.dao = supplyDao();
		for (E e: data) {
			dao.create(e);
		}
	}
	
	@Test
	public void testCreate() {
        List<E> entities = dao.findAll();
        assertTrue(entities.size() == data.size());
        for (E e: data) {
            assertTrue(entities.contains(e));
        }
	}
	
	@Test
	public void testRead() {
        List<E> entities = dao.findAll();
		for (int i = 0; i < entities.size(); i++) {
			E d = entities.get(i);
			E e = dao.read(supplyId(d));
			assertEquals(d, e);
		}
	}
	
	protected abstract E supplyUpdated(E e); // TODO Improve data managing
	
	@Test
	public void testUpdate() {
		List<E> entities = dao.findAll();
		E updated = supplyUpdated(entities.get(0));
		dao.update(entities.get(0));
		entities = dao.findAll();
		assertEquals(updated, entities.get(0));
	}

	protected abstract Integer supplyId(E e); // TODO Improve data managing
	
	@Test
	public void testDeleteById() {
		List<E> entities = dao.findAll();
		for (E e : entities) {
			Integer id = supplyId(e);
			dao.deleteById(id);
			E read = dao.read(id);
			assertNull(read);
		}
	}
}
