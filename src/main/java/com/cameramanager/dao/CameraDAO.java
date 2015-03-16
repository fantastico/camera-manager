package com.cameramanager.dao;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cameramanager.model.Camera;

/**
 * A data access object (DAO) providing persistence and search support for
 * Camera entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.cameramanager.model.Camera
 * @author MyEclipse Persistence Tools
 */
@Transactional
@Repository
public class CameraDAO {
	private static final Logger log = LoggerFactory.getLogger(CameraDAO.class);
	// property constants
	public static final String USER_KEY = "userKey";
	public static final String REQUEST_KEY = "requestKey";
	public static final String STATUS = "status";
	public static final String IP = "ip";
	public static final String MAX_USERS = "maxUsers";
	public static final String CURRENT_USERS = "currentUsers";

	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	protected void initDao() {
		// do nothing
	}

	public void save(Camera transientInstance) {
		log.debug("saving Camera instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Camera persistentInstance) {
		log.debug("deleting Camera instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Camera findById(java.lang.String id) {
		log.debug("getting Camera instance with id: " + id);
		try {
			Camera instance = (Camera) getCurrentSession().get(
					"com.cameramanager.model.Camera", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Camera instance) {
		log.debug("finding Camera instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("com.cameramanager.model.Camera")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Camera instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Camera as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByUserKey(Object userKey) {
		return findByProperty(USER_KEY, userKey);
	}

	public List findByRequestKey(Object requestKey) {
		return findByProperty(REQUEST_KEY, requestKey);
	}

	public List findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}

	public List findByIp(Object ip) {
		return findByProperty(IP, ip);
	}

	public List findByMaxUsers(Object maxUsers) {
		return findByProperty(MAX_USERS, maxUsers);
	}

	public List findByCurrentUsers(Object currentUsers) {
		return findByProperty(CURRENT_USERS, currentUsers);
	}

	public List findAll() {
		log.debug("finding all Camera instances");
		try {
			String queryString = "from Camera";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Camera merge(Camera detachedInstance) {
		log.debug("merging Camera instance");
		try {
			Camera result = (Camera) getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Camera instance) {
		log.debug("attaching dirty Camera instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Camera instance) {
		log.debug("attaching clean Camera instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static CameraDAO getFromApplicationContext(ApplicationContext ctx) {
		return (CameraDAO) ctx.getBean("CameraDAO");
	}
}