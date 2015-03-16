package com.cameramanager.service;

import java.util.List;

import com.cameramanager.model.Bind;
import com.cameramanager.model.Camera;
import com.cameramanager.model.id.BindId;

public interface BindManager extends GenericManager<Bind, BindId> {
	public List<Bind> findByApk_id(String apk_id);
	public List<Bind> findByUsername(String username);
	public List<Camera> findCamera();
	public void insert();
}