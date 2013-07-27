package ru.buildmgr.web.dataModel.clientservices;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("directoryservice")
public interface DirectoryService extends RemoteService{
	
	String greetServer(String name) throws IllegalArgumentException;

}
