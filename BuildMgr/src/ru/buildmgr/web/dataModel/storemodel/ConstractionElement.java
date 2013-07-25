package ru.buildmgr.web.dataModel.storemodel;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.google.appengine.api.datastore.Key;

@Entity
public class ConstractionElement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Key key;
	
	public String name;
	public String elementClassName;
	
	public ConstractionElementType elementType;
	public String elementTypeName;
	
	public ConstractionObjectAddress objectAddress;
	public String objectAddressName;

	public List<ConstractionItemPosition> positions;

}
