package ru.buildmgr.web.dataModel.clientservices;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface DirectoryServiceAsync {

	void greetServer(String name, AsyncCallback<String> callback);

}
