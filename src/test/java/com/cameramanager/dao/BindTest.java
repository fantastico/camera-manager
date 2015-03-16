package com.cameramanager.dao;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cameramanager.model.Bind;

public class BindTest extends BaseDaoTestCase {
	@Autowired
	private BindDao bindDao;

	@Test
	public void testFindBindByApk_id() throws Exception {
		// List<Bind> bind = bindDao.findByApk_id("123456789abc");
		List<Bind> bind = bindDao.findByUsername("admin");
		System.out.println("bind.size()");
		System.out.println(bind.size());
	}

}