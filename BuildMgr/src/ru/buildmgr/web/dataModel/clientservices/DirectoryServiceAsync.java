package ru.buildmgr.web.dataModel.clientservices;

import java.util.List;

import ru.buildmgr.web.dataModel.clientmodel.CMConstractionElement;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface DirectoryServiceAsync {

	void greetServer(String name, AsyncCallback<String> callback);

	void getAllCMConstractionElements(AsyncCallback<List<CMConstractionElement>> callback);

	void createElement(CMConstractionElement element, AsyncCallback<CMConstractionElement> callback);

}
