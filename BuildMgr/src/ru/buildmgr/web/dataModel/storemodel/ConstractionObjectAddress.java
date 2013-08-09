package ru.buildmgr.web.dataModel.storemodel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import ru.buildmgr.web.dataModel.clientmodel.CMConstractionObjectAddress;

import com.google.appengine.api.datastore.Key;

@Entity
public class ConstractionObjectAddress {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Key key;

	private String objectAddressName;

	public ConstractionObjectAddress() {
	}


	public ConstractionObjectAddress(CMConstractionObjectAddress source) {
		setObjectAddressName(source.getName());
	}
	
	public CMConstractionObjectAddress asClient() {
		CMConstractionObjectAddress objectAddress = new CMConstractionObjectAddress();
		objectAddress.setName(getObjectAddressName());
		return objectAddress;
	}

	public Key getKey() {
		return key;
	}

	public void setKey(Key key) {
		this.key = key;
	}

	public String getObjectAddressName() {
		return objectAddressName;
	}

	public void setObjectAddressName(String objectAddressName) {
		this.objectAddressName = objectAddressName;
	}

}
