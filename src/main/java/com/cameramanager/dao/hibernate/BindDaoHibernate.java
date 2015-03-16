package com.cameramanager.dao.hibernate;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.cameramanager.dao.BindDao;
import com.cameramanager.model.Bind;
import com.cameramanager.model.id.BindId;

@Repository("bindDao")
public class BindDaoHibernate extends GenericDaoHibernate<Bind, BindId> implements BindDao {
 
    public BindDaoHibernate() {
        super(Bind.class);
    }
 
    public List<Bind> findByApk_id(String apk_id) {
        return getSession().createCriteria(Bind.class).add(Restrictions.eq("id.apk_id", apk_id)).list();
    }
    
    public List<Bind> findByUsername(String username) {
        return getSession().createCriteria(Bind.class).add(Restrictions.eq("id.username", username)).list();
    }
}