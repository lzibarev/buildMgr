package ru.buildmgr.web.dataModel.services;

import ru.buildmgr.web.dataModel.clientservices.DirectoryService;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class DirectoryServiceImpl extends RemoteServiceServlet implements DirectoryService {

	@Override
	public String greetServer(String name) throws IllegalArgumentException {
		return "Hi "+name+" it is DirectoryService";
	}

}
