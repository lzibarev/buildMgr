package ru.buildmgr.web.dataModel.storemodel;

import java.util.List;

public class Request {

	public String requestName;
	public int requestNumber;
	public String requestDescription;
	public ConstractionObjectAddress objectAddress;
	public String objectAddressName;
	
	public List<ConstractionItemPosition> positions;

}
