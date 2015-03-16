package com.cameramanager.service;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cameramanager.dao.BindDao;
import com.cameramanager.model.Bind;
import com.cameramanager.model.Camera;
import com.cameramanager.model.id.BindId;
import com.cameramanager.util.AuthenticationUtil;

@Service("cameraManager")
public class CameraManager extends ManagerSupport{
	
	@Autowired
	BindDao bindDao;
	
	@Autowired
	public CameraManager(SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	@Transactional
	public void bindCamera(String apk_i) throws HibernateException{
		Bind bind = new Bind(new BindId(AuthenticationUtil.getUser().getUsername(), apk_i));
		Session session = getSession();
		session.save(bind);
	}
	
	@Transactional
	public void deleteCamera(String apkId){
		Session session = getSession();
		Query query = session.createQuery("delete from Bind where id.apk_id = (:apkId) and id.username = (:username)");
		query.setParameter("apkId", apkId);
		query.setParameter("username", AuthenticationUtil.getUser().getUsername());
		query.executeUpdate();
	}

	@Transactional
	public List<Camera> findCamera() {
		Session session = getSession();
		Query query = session.createQuery("select c from Camera c, Bind b "
				+ "where b.id.username = (:username) and c.apkId = b.id.apk_id");
		query.setParameter("username", AuthenticationUtil.getUser().getUsername());
		List<Camera> cameraList = query.list();
		return cameraList;
	}
	
	@Transactional
	public Camera findCameraById(String apkId) {
		Session session = getSession();
		Query query = session.createQuery("select c from Camera c, Bind b "
				+ "where b.id.username = (:username) and c.apkId = (:apkId) and c.apkId = b.id.apk_id");
		query.setParameter("apkId", apkId);
		query.setParameter("username", AuthenticationUtil.getUser().getUsername());
		List<Camera> cameraList = query.list();
		if(cameraList != null && !cameraList.isEmpty()){
			return cameraList.get(0);
		}
		return null;
	}
	
	
	
}