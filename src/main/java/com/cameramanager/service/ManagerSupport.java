package com.cameramanager.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ManagerSupport {

	private SessionFactory sessionFactory;

	public ManagerSupport(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
}
