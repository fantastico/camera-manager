package com.cameramanager.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Camera entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "camera", catalog = "camera_manager")
public class Camera implements java.io.Serializable {

	// Fields

	private String apkId;
	private String userKey;
	private String requestKey;
	private String status;
	private String ip;
	private Short maxUsers;
	private Short currentUsers;

	// Constructors

	/** default constructor */
	public Camera() {
	}

	/** minimal constructor */
	public Camera(String apkId) {
		this.apkId = apkId;
	}

	/** full constructor */
	public Camera(String apkId, String userKey, String requestKey,
			String status, String ip, Short maxUsers, Short currentUsers) {
		this.apkId = apkId;
		this.userKey = userKey;
		this.requestKey = requestKey;
		this.status = status;
		this.ip = ip;
		this.maxUsers = maxUsers;
		this.currentUsers = currentUsers;
	}

	// Property accessors
	@Id
	@Column(name = "apk_id", unique = true, nullable = false, length = 32)
	public String getApkId() {
		return this.apkId;
	}

	public void setApkId(String apkId) {
		this.apkId = apkId;
	}

	@Column(name = "user_key", length = 32)
	public String getUserKey() {
		return this.userKey;
	}

	public void setUserKey(String userKey) {
		this.userKey = userKey;
	}

	@Column(name = "request_key", length = 32)
	public String getRequestKey() {
		return this.requestKey;
	}

	public void setRequestKey(String requestKey) {
		this.requestKey = requestKey;
	}

	@Column(name = "status", length = 7)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "ip")
	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	@Column(name = "max_users")
	public Short getMaxUsers() {
		return this.maxUsers;
	}

	public void setMaxUsers(Short maxUsers) {
		this.maxUsers = maxUsers;
	}

	@Column(name = "current_users")
	public Short getCurrentUsers() {
		return this.currentUsers;
	}

	public void setCurrentUsers(Short currentUsers) {
		this.currentUsers = currentUsers;
	}

}