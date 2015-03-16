package com.cameramanager.dao;

import java.util.List;

import com.cameramanager.model.Bind;
import com.cameramanager.model.id.BindId;

public interface BindDao extends GenericDao<Bind, BindId> {
	public List<Bind> findByApk_id(String apk_id);
	public List<Bind> findByUsername(String username);
}