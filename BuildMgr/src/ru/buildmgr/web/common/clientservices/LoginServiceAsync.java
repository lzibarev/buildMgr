package ru.buildmgr.web.common.clientservices;

import ru.buildmgr.web.common.clientdata.LoginInfo;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface LoginServiceAsync {

	void login(String requestUri, AsyncCallback<LoginInfo> callback);

}
