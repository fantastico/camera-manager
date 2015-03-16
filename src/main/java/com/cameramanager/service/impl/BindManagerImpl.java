package com.cameramanager.service.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cameramanager.dao.BindDao;
import com.cameramanager.model.Bind;
import com.cameramanager.model.Camera;
import com.cameramanager.model.id.BindId;
import com.cameramanager.service.BindManager;
import com.cameramanager.util.AuthenticationUtil;

@Service("bindManager")
public class BindManagerImpl extends GenericManagerImpl<Bind, BindId>
		implements BindManager {
	
	BindDao bindDao;

	@Autowired
	public BindManagerImpl(@Qualifier("bindDao") BindDao bindDao) {
		super(bindDao);
		this.bindDao = bindDao;
	}

	public List<Bind> findByUsername(String username) {
		return bindDao.findByUsername(username);
	}
	
	public List<Bind> findByApk_id(String apk_id) {
		return bindDao.findByApk_id(apk_id);
	}
	
	public void insert(){
		Session session = bindDao.getSession();
		Query query = session.createQuery("delete from Bind ");
		query.executeUpdate();
	}

	@Override
	public List<Camera> findCamera() {
		Session session = bindDao.getSession();
		Query query = session.createQuery("select c from Camera c, Bind b "
				+ "where b.id.username = (:username) and c.apkId = b.id.apk_id");
		String username = AuthenticationUtil.getUser().getUsername();
		query.setParameter("username", username);
		List<Camera> cameraList = query.list();
		return cameraList;
	}
	
	

	
	
}