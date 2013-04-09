package org.cognoscenti.dao;

import java.util.List;
import java.util.Map;

public interface DataAccessObject {
	<T> T add(T e, Class<T> clazz);
	<T> T update(T e, Class<T> clazz);
	void remove(Object o);
	<T> T get(Object id, Class<T> clazz);
	<T> List<T> findAll(Class<T> clazz);
	<T> List<T> find(Class<T> clazz, Map<String, Object> parameters);
}