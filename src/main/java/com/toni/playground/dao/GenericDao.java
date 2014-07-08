package com.toni.playground.dao;

import java.io.Serializable;
import java.util.List;

import com.toni.playground.dao.exception.AlreadyExistsDAOException;
import com.toni.playground.dao.exception.CreateDAOException;

/**
 * @author tonilap 
 */
public interface GenericDao<T, ID extends Serializable> {
	
	/**
	 * Creates a new instance
	 * 
	 * @param instance the instance to create
	 * @return the new instance
	 * @throws AlreadyExistsDAOException when the instance T already exists
	 * @throws CreateDAOException when the instance T cannot be saved due an unexpected data access error
	 */
	public T save(T instance) throws AlreadyExistsDAOException, CreateDAOException;
	
	/**
	 * Updates an instance
	 * 
	 * @param instance the instance to update
	 */
	public void update(T instance);
	
	/**
	 * Deletes an instance
	 * 
	 * @param instance the instance to delete
	 */
	public void delete(T instance);
	
	/**
	 * Gets the instance with identifier id
	 * 
	 * @param id the identifier of the instance
	 * @return and instance which identifier is id
	 */
	public T findById(ID id);
	
	/**
	 * Gets the collection of instances of T
	 * 
	 * @return the list of T
	 */
	public List<T> findAll();
}
