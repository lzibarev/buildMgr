package ru.buildmgr.web.dataModel.storemodel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import ru.buildmgr.web.dataModel.clientmodel.CMConstractionElement;

import com.google.appengine.api.datastore.Key;

@Entity
public class ConstractionElement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Key key;

	private String name;
	private String elementClassName;

	// public ConstractionElementType elementType;
	private String elementTypeName;

	// public ConstractionObjectAddress objectAddress;
	private String objectAddressName;

	// public List<ConstractionItemPosition> positions;

	public ConstractionElement() {

	}

	public ConstractionElement(CMConstractionElement source) {
		this();
		setName(source.getName());
		setElementClassName(source.getClassName());
		setElementTypeName(source.getTypeName());
		setObjectAddressName(source.getObjectAddressName());

	}

	public CMConstractionElement asClient() {
		CMConstractionElement e = new CMConstractionElement();
		e.setName(getName());

		e.setId(getKey().getKind());
		e.setClassName(getElementClassName());
		e.setObjectAddressName(getObjectAddressName());
		e.setTypeName(getElementTypeName());

		return e;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Key getKey() {
		return key;
	}

	public void setKey(Key key) {
		this.key = key;
	}

	public String getElementClassName() {
		return elementClassName;
	}

	public void setElementClassName(String elementClassName) {
		this.elementClassName = elementClassName;
	}

	public String getElementTypeName() {
		return elementTypeName;
	}

	public void setElementTypeName(String elementTypeName) {
		this.elementTypeName = elementTypeName;
	}

	public String getObjectAddressName() {
		return objectAddressName;
	}

	public void setObjectAddressName(String objectAddressName) {
		this.objectAddressName = objectAddressName;
	}
}
