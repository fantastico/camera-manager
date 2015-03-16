package com.cameramanager.dao;

import java.util.List;

import com.cameramanager.model.Person;

public interface PersonDao extends GenericDao<Person, Long> {
	public List<Person> findByLastName(String lastName);
}