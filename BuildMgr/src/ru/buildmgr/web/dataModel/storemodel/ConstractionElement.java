package ru.buildmgr.web.dataModel.storemodel;

import java.util.List;

public class ConstractionElement {

	public String name;
	public String elementClassName;
	
	public ConstractionElementType elementType;
	public String elementTypeName;
	
	public ConstractionObjectAddress objectAddress;
	public String objectAddressName;

	public List<ConstractionItemPosition> positions;

}
