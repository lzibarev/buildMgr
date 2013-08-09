package ru.buildmgr.web.dataModel.clientservices;

import java.util.List;

import ru.buildmgr.web.dataModel.clientmodel.CMConstractionElement;
import ru.buildmgr.web.dataModel.clientmodel.CMConstractionElementType;
import ru.buildmgr.web.dataModel.clientmodel.CMConstractionObjectAddress;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("directoryservice")
public interface DirectoryService extends RemoteService {

	String greetServer(String name) throws IllegalArgumentException;

	List<CMConstractionElement> getAllCMConstractionElements();

	CMConstractionElement createElement(CMConstractionElement element) throws IllegalArgumentException;

	List<CMConstractionElementType> getAllCMConstractionElementTypes();

	CMConstractionElementType createElementType(CMConstractionElementType source) throws IllegalArgumentException;
	
	List<CMConstractionObjectAddress> getAllCMConstractionObjectAddresses();
	
	CMConstractionObjectAddress createObjectAddress(CMConstractionObjectAddress source) throws IllegalArgumentException;
}
