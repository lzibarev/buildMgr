package ru.buildmgr.web.dataModel.clientmodel;

import java.io.Serializable;

@SuppressWarnings("serial")
public class CMConstractionElement implements Serializable {
	private String id;
	private String name;
	private String className;
	private String typeName;
	private String objectAddressName;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getObjectAddressName() {
		return objectAddressName;
	}

	public void setObjectAddressName(String objectAddressName) {
		this.objectAddressName = objectAddressName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
