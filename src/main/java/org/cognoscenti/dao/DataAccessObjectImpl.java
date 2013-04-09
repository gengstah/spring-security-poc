package org.cognoscenti.dao;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class DataAccessObjectImpl implements DataAccessObject {
	@PersistenceContext
	private EntityManager entityManager;
	
	public DataAccessObjectImpl() { }

	@Override
	public <T> List<T> findAll(Class<T> clazz) {
		String query = "SELECT type FROM " + clazz.getName() + " type";
		return entityManager.createQuery(query, clazz).getResultList();
	}

	@Override
	public <T> T add(T e, Class<T> clazz) {
		entityManager.persist(e);
		return e;
	}

	@Override
	public <T> T update(T e, Class<T> clazz) {
		return entityManager.merge(e);
	}

	@Override
	public void remove(Object o) {
		entityManager.remove(o);
	}

	@Override
	public <T> T get(Object id, Class<T> clazz) {
		return entityManager.find(clazz, id);
	}

	@Override
	public <T> List<T> find(Class<T> clazz, Map<String, Object> parameters) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<T> c = cb.createQuery(clazz);
		Root<T> root = c.from(clazz);
		c.select(root);
		
		for(String fieldName : parameters.keySet()) {
			c.where(cb.equal(root.get(fieldName), parameters.get(fieldName)));
		}
		
		return entityManager.createQuery(c).getResultList();
	}
}