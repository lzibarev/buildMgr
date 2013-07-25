package ru.buildmgr.web.request.ditectory;

import ru.buildmgr.web.request.ditectory.client.DirectoryService;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class DirectoryServiceImpl extends RemoteServiceServlet implements DirectoryService {

	@Override
	public String greetServer(String name) throws IllegalArgumentException {
		return "test";
	}

}
