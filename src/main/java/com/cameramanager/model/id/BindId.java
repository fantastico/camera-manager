package com.cameramanager.model.id;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;

import com.cameramanager.model.BaseObject;
import com.cameramanager.model.Bind;

@Embeddable
public class BindId extends BaseObject{
	
	private static final long serialVersionUID = 3690197650654049003L;
	
	@Column(name="username", length=50)
	private String username;
	
	@Column(name="apk_id", length=32)
	private String apk_id;

	public BindId(String username, String apk_id) {
		super();
		this.username = username;
		this.apk_id = apk_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getApk_id() {
		return apk_id;
	}

	public void setApk_id(String apk_id) {
		this.apk_id = apk_id;
	}

	@Override
	public String toString() {
		return "BindId [username=" + username + ", apk_id=" + apk_id + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apk_id == null) ? 0 : apk_id.hashCode());
		result = prime * result
				+ ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BindId other = (BindId) obj;
		if (apk_id == null) {
			if (other.apk_id != null)
				return false;
		} else if (!apk_id.equals(other.apk_id))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	
}