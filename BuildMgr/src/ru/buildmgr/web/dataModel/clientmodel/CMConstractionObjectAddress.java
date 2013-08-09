package ru.buildmgr.web.dataModel.clientmodel;

import java.io.Serializable;

@SuppressWarnings("serial")
public class CMConstractionObjectAddress implements Serializable {

	private String id;
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
