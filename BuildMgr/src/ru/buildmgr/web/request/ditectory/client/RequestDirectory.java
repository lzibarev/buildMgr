package ru.buildmgr.web.request.ditectory.client;

import ru.buildmgr.web.request.ditectory.client.forms.EmelentManagerForm;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

public class RequestDirectory implements EntryPoint {

	private static String MAIN_CONTAINER = "mainContainer";

	@Override
	public void onModuleLoad() {
		EmelentManagerForm form = new EmelentManagerForm();
		getMainContainer().add(form);
	}

	public static RootPanel getMainContainer() {
		return RootPanel.get(MAIN_CONTAINER);
	}

}
