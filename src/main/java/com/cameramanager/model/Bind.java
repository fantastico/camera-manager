package com.cameramanager.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.cameramanager.model.id.BindId;

// import com.cameramanager.model.Bind.BindPK;

@Entity
@Table(name = "user_to_camera")
public class Bind extends BaseObject {

	private static final long serialVersionUID = 3690197650654049002L;
	
	@EmbeddedId
	private BindId id;

	public Bind(BindId id) {
		super();
		this.id = id;
	}

	public BindId getId() {
		return id;
	}

	public void setId(BindId id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Bind [id=" + id + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Bind other = (Bind) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
}
