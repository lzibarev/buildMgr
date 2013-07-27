package ru.buildmgr.web.dataModel.storemodel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import ru.buildmgr.web.dataModel.clientmodel.CMConstractionElementType;

import com.google.appengine.api.datastore.Key;

@Entity
public class ConstractionElementType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Key key;

	private String elementTypeName;

	public ConstractionElementType() {

	}

	public ConstractionElementType(CMConstractionElementType source) {
		setElementTypeName(source.getName());
	}

	public CMConstractionElementType asClient() {
		CMConstractionElementType elementType = new CMConstractionElementType();
		elementType.setName(getElementTypeName());
		return elementType;
	}

	public String getElementTypeName() {
		return elementTypeName;
	}

	public void setElementTypeName(String elementTypeName) {
		this.elementTypeName = elementTypeName;
	}

	public Key getKey() {
		return key;
	}

	public void setKey(Key key) {
		this.key = key;
	}

}
