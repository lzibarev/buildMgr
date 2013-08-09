package ru.buildmgr.web.common.client;

import ru.buildmgr.web.common.clientdata.LoginInfo;
import ru.buildmgr.web.common.clientservices.LoginService;
import ru.buildmgr.web.common.clientservices.LoginServiceAsync;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public abstract class WebCommonEntryPoint implements EntryPoint {

	private LoginInfo loginInfo = null;
	private VerticalPanel loginPanel = new VerticalPanel();
	private Label loginLabel = new Label("Необходимо авторизоваться");
	private Anchor signInLink = new Anchor("Вход");
	private Anchor signOutLink = new Anchor("Выход");

	@Override
	public void onModuleLoad() {
		checkLogin();
	}

	protected void checkLogin() {
		LoginServiceAsync loginService = GWT.create(LoginService.class);
		loginService.login(GWT.getHostPageBaseURL(), new AsyncCallback<LoginInfo>() {
			public void onFailure(Throwable error) {

			}

			public void onSuccess(LoginInfo result) {
				loginInfo = result;
				if (loginInfo.isLoggedIn()) {
					signOutLink.setHref(loginInfo.getLogoutUrl());
					getRootPanel().add(signOutLink);
					showModule();
				} else {
					loadLogin();
				}
			}
		});
	}

	private void loadLogin() {
		signInLink.setHref(loginInfo.getLoginUrl());
		loginPanel.add(loginLabel);
		loginPanel.add(signInLink);
		getRootPanel().add(loginPanel);
	}

	protected abstract void showModule();

	protected abstract RootPanel getRootPanel();
}
