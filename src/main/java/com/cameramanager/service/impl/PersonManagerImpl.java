package com.cameramanager.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cameramanager.dao.PersonDao;
import com.cameramanager.model.Person;
import com.cameramanager.service.PersonManager;

@Service("personManager")
public class PersonManagerImpl extends GenericManagerImpl<Person, Long>
		implements PersonManager {
	PersonDao personDao;

	public PersonManagerImpl(PersonDao personDao) {
		super(personDao);
		this.personDao = personDao;
	}

	public List<Person> findByLastName(String lastName) {
		return personDao.findByLastName(lastName);
	}
}