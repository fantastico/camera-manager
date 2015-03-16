package com.cameramanager.service;

import java.util.List;

import com.cameramanager.model.Person;

public interface PersonManager extends GenericManager<Person, Long> {
    List<Person> findByLastName(String lastName);
}