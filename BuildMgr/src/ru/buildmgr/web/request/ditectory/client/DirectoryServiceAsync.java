package ru.buildmgr.web.request.ditectory.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface DirectoryServiceAsync {

	void greetServer(String input, AsyncCallback<String> callback) throws IllegalArgumentException;

}
